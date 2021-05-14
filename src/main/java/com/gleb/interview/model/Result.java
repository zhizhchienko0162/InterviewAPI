package com.gleb.interview.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESULT")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @ManyToOne
    Interview interview;
    @ManyToMany
    Set<Answer> answers;

    public Result() {}

    public Result(Long userId, Interview interview, Set<Answer> answers) {
        this.userId = userId;
        this.interview = interview;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Interview getInterview() {
        return interview;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }
}
