package com.gleb.interview.db;

import com.gleb.interview.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, InterviewRepository interviewRepository,
                                   QuestionRepository questionRepository, AnswerRepository answerRepository,
                                   ResultRepository resultRepository) {

        return args -> {
            userRepository.save(new User("Admin", "admin", "password"));
            userRepository.save(new User("Admin", "guest", "passwd"));

            Set<Question> qs = new HashSet<>();

            qs.add(new Question("How are you?", "text"));
            qs.add(new Question("How old are you?", "multiple"));
            qs.add(new Question("What is your gender?", "single"));
            qs.forEach(questionRepository::save);

            Interview interview = new Interview("Test1", 123L, 1234L, "", 1L, qs.stream().limit(2).collect(Collectors.toSet()));

            interviewRepository.save(interview);
        };
    }
}
