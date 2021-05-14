package com.gleb.interview.model;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String answer;

    public Answer() {}

    public Answer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
