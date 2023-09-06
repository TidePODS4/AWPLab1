package com.awp.lab1.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private boolean isAdmin;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
