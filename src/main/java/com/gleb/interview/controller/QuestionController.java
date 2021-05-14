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

    /**
     * @api {get} /question/all
     * @apiName getQuestions
     * @apiGroup Question
     *
     * @apiSuccess {List(Questions)} questions all questions
     */
    @GetMapping("/question/all")
    List<Question> all() {
        return questionRepository.findAll();
    }

    /**
     * @api {post} /question/add
     * @apiName addQuestions
     * @apiGroup Question
     *
     * @apiParam {Wrapper(User_Set(Questions))} wrapper login user and set of questions
     * @apiSuccess {Set(Questions)} questions set of questions
     */
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

    /**
     * @api {put} /question/update
     * @apiName updateQuestions
     * @apiGroup Question
     *
     * @apiParam {Wrapper(User_Set(Questions))} wrapper login user and set of updated questions
     * @apiSuccess {Set(Questions)} questions set of questions
     */
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

    /**
     * @api {delete} /question/delete
     * @apiName deleteQuestions
     * @apiGroup Question
     *
     * @apiParam {Wrapper(User_Set(Questions))} wrapper login user and set of questions to delete
     */
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
