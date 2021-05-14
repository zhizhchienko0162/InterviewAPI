package com.gleb.interview.controller;

import com.gleb.interview.db.UserRepository;
import com.gleb.interview.exception.NotFoundException;
import com.gleb.interview.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("user"));
    }

    /**
     * @api {post} /user/login
     * @apiName LoginUser
     * @apiGroup User
     *
     * @apiParam {User} user id and password
     * @apiSuccess {User} user login User
     */
    @PostMapping("/users/login")
    User login(@RequestBody User user) {
        return repository.findById(user.getId())
                .map(_user -> {
                    repository.saveAndFlush(_user.login(user.getPassword()));
                    return _user;
                })
                .orElseThrow(() -> new NotFoundException("user"));
    }

    /**
     * @api {post} /user/logout
     * @apiName LogoutUser
     * @apiGroup User
     *
     * @apiParam {User} user login User
     */
    @PostMapping("/users/logout")
    void logout(@RequestBody User user) {
        repository.findById(user.getId())
                .map(_user -> repository.saveAndFlush(_user.logout(user.getToken())))
                .orElseThrow(() -> new NotFoundException("user"));
    }
}
