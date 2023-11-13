package com.awp.lab1.database;

import com.awp.lab1.entity.User;
import com.awp.lab1.exception.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserTable {
    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "admin", true));
    }

    public static void addUser(User user) throws UserAlreadyExistsException{
        if (isUserExists(user.getLogin())){
            throw new UserAlreadyExistsException(user);
        }

        users.put(user.getLogin(), user);
    }

    public static List<User> getAllUsers(){
        return users.values().stream().toList();
    }

    private static boolean isUserExists(String login){
        if (login == null)
            return false;
        return users.containsKey(login);
    }

    private static boolean isPasswordCorrect(User user){
        if (user.getPassword() == null)
            return false;
        return users.get(user.getLogin()).getPassword().equals(user.getPassword());
    }

    private static User getUserFromDatabase(String login){
        return users.get(login);
    }

    public static Optional<User> login(User user){
        if (isUserExists(user.getLogin()) && isPasswordCorrect(user)){
            return Optional.of(getUserFromDatabase(user.getLogin()));
        }
        return Optional.empty();
    }

    public static void update(User user){
        if (isUserExists(user.getLogin())){
            var dbUser = users.get(user.getLogin());
            dbUser.setPassword(user.getPassword());
            dbUser.setAdmin(user.getAdmin());
        }
    }

    public static void deleteByLogin(String login) {
        users.remove(login);
    }
}
