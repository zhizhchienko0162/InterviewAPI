package com.gleb.interview.controller;

import com.gleb.interview.db.InterviewRepository;
import com.gleb.interview.db.QuestionRepository;
import com.gleb.interview.db.UserRepository;
import com.gleb.interview.exception.NotFoundException;
import com.gleb.interview.model.Interview;
import com.gleb.interview.model.Question;
import com.gleb.interview.model.User;
import com.gleb.interview.model.Wrapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class InterviewController {
    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;
    private final QuestionRepository questionRepository;

    public InterviewController(UserRepository userRepository, InterviewRepository interviewRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.interviewRepository = interviewRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/interview/all")
    List<Interview> all() {
        return interviewRepository.findAll();
    }

    @PostMapping("/interview/create")
    Interview newInterview(@RequestBody Wrapper<User, Interview> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Interview interview = wrapper.getClassB();
            Set<Question> questions = new HashSet<>(interview.getQuestions());

            questions.stream()
                    .filter(q -> !questionRepository.existsById(q.getBody()))
                    .forEach(q -> interview.getQuestions().remove(q));

            if (!interviewRepository.existsById(interview.getName())) {
                return interviewRepository.save(
                        new Interview(interview.getName(), interview.getStart(), interview.getStop(), interview.getDescription(), user.getId(), interview.getQuestions()));
            }
        }

        return null;
    }

    @PutMapping("/interview/update")
    Interview updateInterview(@RequestBody Wrapper<User, Interview> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Interview interview = wrapper.getClassB();

            return interviewRepository.findById(interview.getName())
                    .map(i -> {
                        i.setStop(interview.getStop());
                        i.setDescription(interview.getDescription());
                        return interviewRepository.saveAndFlush(i);
                    })
                    .orElseThrow(() -> new NotFoundException("interview"));
        } else {
            return null;
        }
    }

    @DeleteMapping("/interview/delete")
    void delInterview(@RequestBody Wrapper<User, Interview> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            interviewRepository.deleteById(wrapper.getClassB().getName());
        }
    }

    @PutMapping("/interview/add_question")
    Interview addQuestion(@RequestBody Wrapper<User, Interview> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Interview interview = wrapper.getClassB();

            return interviewRepository.findById(interview.getName())
                    .map(i -> {
                        interview.getQuestions().stream()
                                .filter(q -> questionRepository.existsById(q.getBody()))
                                .forEach(i::addQuestion);

                        return interviewRepository.saveAndFlush(i);
                    })
                    .orElseThrow(() -> new NotFoundException("interview"));
        }

        return null;
    }

    @DeleteMapping("/interview/del_question")
    Interview delQuestion(@RequestBody Wrapper<User, Interview> wrapper) {
        User user = userRepository.findByToken(wrapper.getClassA().getToken());

        if (user != null && user.isAdmin()) {
            Interview interview = wrapper.getClassB();

            return interviewRepository.findById(interview.getName())
                    .map(i -> {
                        interview.getQuestions()
                                .forEach(i::delQuestion);

                        return interviewRepository.saveAndFlush(i);
                    })
                    .orElseThrow(() -> new NotFoundException("interview"));
        }

        return null;
    }
}
