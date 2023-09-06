package com.awp.lab1.exception;

import com.awp.lab1.entity.User;
import lombok.Getter;

public class UserDoesNotExists extends Exception{
    @Getter
    private final User user;

    public UserDoesNotExists(User user) {
        super("User " + user.getLogin() + "does not exists");
        this.user = user;
    }
}
