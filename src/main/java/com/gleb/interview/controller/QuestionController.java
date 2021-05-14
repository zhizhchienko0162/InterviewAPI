package com.gleb.interview.controller;

import com.gleb.interview.db.QuestionRepository;
import com.gleb.interview.db.UserRepository;
import com.gleb.interview.model.Question;
import com.gleb.interview.model.User;
import com.gleb.interview.model.Wrapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionController(QuestionRepository repository, UserRepository userRepository) {
        this.questionRepository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/question/all")
    List<Question> all() {
        return questionRepository.findAll();
    }

    @PostMapping("/question/add")
    Set<Question> addQuestions(@RequestBody Wrapper<User, Set<Question>> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Set<Question> questions = wrapper.getClassB();
            Set<Question> out = new HashSet<>();

            questions.stream().filter(q -> !questionRepository.existsById(q.getBody()))
                    .forEach(q -> {
                        questionRepository.saveAndFlush(q);
                        out.add(questionRepository.findById(q.getBody()).orElseThrow(() -> new RuntimeException("Error")));
                    });

            return out;
        }

        return null;
    }

    @PutMapping("/question/update")
    Set<Question> updateQuestions(@RequestBody Wrapper<User, Set<Question>> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Set<Question> questions = wrapper.getClassB();
            Set<Question> out = new HashSet<>();

            questions.stream().filter(q -> questionRepository.existsById(q.getBody()))
                    .forEach(q -> questionRepository.findById(q.getBody())
                            .ifPresent(_q -> {
                                _q.setBody(q.getBody());
                                _q.setType(q.getType());
                                out.add(questionRepository.saveAndFlush(_q));
                            }));

            return out;
        }

        return null;
    }

    @DeleteMapping("/question/delete")
    void deleteQuestions(@RequestBody Wrapper<User, Set<Question>> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            wrapper.getClassB().stream().filter(q -> questionRepository.existsById(q.getBody()))
                    .forEach(q -> questionRepository.findById(q.getBody())
                            .ifPresent(questionRepository::delete));

        }
    }
}
