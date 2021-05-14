package com.gleb.interview.db;

import com.gleb.interview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from USERS where token=?1", nativeQuery = true)
    User findByToken(String token);
}
