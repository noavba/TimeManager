package com.example.timemanager.user;

public interface UserService {
    User getUser(Integer id);

    String addUser(User user);

    String updateUser(User user);

    Iterable<User> getAllUsers();

    String deleteUser(Integer id);


}
