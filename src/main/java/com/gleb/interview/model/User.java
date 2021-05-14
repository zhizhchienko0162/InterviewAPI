package com.gleb.interview.model;

import com.gleb.interview.exception.LoginException;
import com.gleb.interview.exception.LogoutException;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Roles role;
    @Column(unique=true)
    private String token;
    @NotNull
    private String password;

    public User() {}

    public User(String name, String role, String password) {
        this.name = name;
        this.role = Roles.getRoleByName(role);
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role.getRole();
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = Roles.getRoleByName(role);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return token != null;
    }

    public boolean isAdmin() {
        return role.equals(Roles.getRoleByName("admin"));
    }

    public User login(String password) {
        if (isLogin()) {
            throw new LoginException("User is login");
        }

        if (!this.password.equals(password)) {
            throw new LoginException("Invalid password");
        }

        token = UUID.randomUUID().toString();

        return this;
    }

    public User logout(String token) {
        if (isLogin()) {
            if (this.token.equals(token)) {
                this.token = null;

                return this;
            } else {
                throw new LogoutException("Invalid token");
            }
        }

        throw new LogoutException("User is not login");
    }
}
