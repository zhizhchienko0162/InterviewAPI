package com.gleb.interview.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INTERVIEW")
public class Interview {
    @Id
    private String name;
    @Column(nullable = false)
    private Long start;
    private Long stop;
    private String description;
    @Column(nullable = false)
    private Long creator;
    @ManyToMany
    private Set<Question> questions;

    public Interview() {}

    public Interview(String name, Long start, Long stop, String description, Long creator, Set<Question> questions) {
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.description = description;
        this.creator = creator;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public Long getStart() {
        return start;
    }

    public Long getStop() {
        return stop;
    }

    public String getDescription() {
        return description;
    }

    public Long getCreator() {
        return creator;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setStop(Long stop) {
        this.stop = stop;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void delQuestion(Question q) {
        (new HashSet<>(questions)).stream()
                .filter(q::equals)
                .forEach(questions::remove);
    }
}
