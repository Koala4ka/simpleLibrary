package com.library.service;

import com.library.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

}
