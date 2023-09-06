package com.awp.lab1.database;

import com.awp.lab1.entity.User;
import com.awp.lab1.exception.UserAlreadyExistsException;
import com.awp.lab1.exception.UserDoesNotExists;

import java.util.HashMap;
import java.util.Map;

public class UserTable {
    private static final Map<String, User> users = new HashMap<>();

    public static void addUser(User user) throws UserAlreadyExistsException{
        if (isUserExists(user.getLogin())){
            throw new UserAlreadyExistsException(user);
        }

        users.put(user.getLogin(), user);
    }

    private static boolean isUserExists(String login){
        return users.containsKey(login);
    }

    private static boolean isPasswordCorrect(User user){
        return users.get(user.getLogin()).getPassword().equals(user.getPassword());
    }

    private static boolean login(User user) throws UserDoesNotExists{
        if (!isUserExists(user.getLogin())){
            throw new UserDoesNotExists(user);
        }

        return users.get(user.getLogin()).getPassword().equals(user.getPassword());
    }
}
