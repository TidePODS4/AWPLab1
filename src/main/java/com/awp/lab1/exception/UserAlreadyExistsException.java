package com.awp.lab1.exception;


import com.awp.lab1.entity.User;

public class UserAlreadyExistsException extends Exception{
    private final User user;

    public UserAlreadyExistsException(User user) {
        super("User " + user.getLogin() + "already exists");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
