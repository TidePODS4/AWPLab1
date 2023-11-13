package com.awp.lab1.exception;

import com.awp.lab1.entity.User;

public class UserDoesNotExistsException extends Exception{
    private final User user;

    public UserDoesNotExistsException(User user) {
        super("User " + user.getLogin() + "does not exists");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
