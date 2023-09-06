package com.awp.lab1.database;

import com.awp.lab1.entity.User;
import com.awp.lab1.exception.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserTable {
    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "admin", true));
    }

    public static void addUser(User user) throws UserAlreadyExistsException{
        if (isUserExists(user)){
            throw new UserAlreadyExistsException(user);
        }

        users.put(user.getLogin(), user);
    }

    private static boolean isUserExists(User user){
        return users.containsKey(user.getLogin());
    }

    private static boolean isPasswordCorrect(User user){
        return users.get(user.getLogin()).getPassword().equals(user.getPassword());
    }

    private static User getUserFromDatabase(String login){
        return users.get(login);
    }

    public static Optional<User> login(User user){
        if (!isUserExists(user) && isPasswordCorrect(user)){
            return Optional.empty();
        }

        return Optional.of(getUserFromDatabase(user.getLogin()));
    }
}
