package com.gleb.interview.db;

import com.gleb.interview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, String> {
}
