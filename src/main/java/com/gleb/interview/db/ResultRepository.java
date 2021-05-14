package com.gleb.interview.db;

import com.gleb.interview.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query(value = "select * from RESULT where user_id=?1", nativeQuery = true)
    Optional<List<Result>> findByUId(Long id);
}
