package com.gleb.interview.controller;

import com.gleb.interview.db.AnswerRepository;
import com.gleb.interview.db.InterviewRepository;
import com.gleb.interview.db.ResultRepository;
import com.gleb.interview.db.UserRepository;
import com.gleb.interview.exception.NotFoundException;
import com.gleb.interview.model.Interview;
import com.gleb.interview.model.Result;
import com.gleb.interview.model.User;
import com.gleb.interview.model.Wrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {
    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;
    private final ResultRepository resultRepository;
    private final AnswerRepository answerRepository;

    public ResultController(UserRepository userRepository, InterviewRepository interviewRepository,
                            ResultRepository resultRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.interviewRepository = interviewRepository;
        this.resultRepository = resultRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/result/all")
    List<Result> all(@RequestBody User user) {
        user = userRepository.findByToken(user.getToken());

        if (user != null) {
            return resultRepository.findByUId(user.getId())
                    .orElseThrow(() -> new NotFoundException("user"));
        } else {
            return null;
        }
    }

    @PostMapping("/result/add")
    Result addResult(@RequestBody Wrapper<User, Result> wrapper) {
        Interview interview = interviewRepository.findById(wrapper.getClassB().getInterview().getName())
                .orElseThrow(() -> new NotFoundException("interview"));
        User user = userRepository.findByToken(wrapper.getClassA().getToken());
        Long id = (user == null)? 0: user.getId();
        wrapper.getClassB().getAnswers().forEach(answerRepository::saveAndFlush);

        return resultRepository.saveAndFlush(new Result(id, interview, wrapper.getClassB().getAnswers()));
    }
}
