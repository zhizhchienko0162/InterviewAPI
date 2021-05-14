package com.gleb.interview.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    private String body;
    private QType type = QType.text;

    public Question() {}

    public Question(String body, String type) {
        this.body = body;
        this.type = QType.getTypeByName(type);
    }

    public String getBody() {
        return body;
    }

    public String getType() {
        return type.getType();
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setType(String type) {
        this.type = QType.getTypeByName(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return body.equals(((Question)o).body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, type);
    }
}
