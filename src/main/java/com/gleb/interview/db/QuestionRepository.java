package com.gleb.interview.db;

import com.gleb.interview.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
