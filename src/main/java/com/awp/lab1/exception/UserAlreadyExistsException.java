package com.awp.lab1.exception;


import com.awp.lab1.entity.User;
import lombok.Getter;

public class UserAlreadyExistsException extends Exception{
    @Getter
    private final User user;

    public UserAlreadyExistsException(User user) {
        super("User " + user.getLogin() + "already exists");
        this.user = user;
    }
}
