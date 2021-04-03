package com.library.controller;

import com.library.model.User;
import com.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Long id) {
        return userDao.findById(id);
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
        Optional<User> user = userDao.findById(id);
        User user_new = user.get();

        return userDao.save(user_new);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        Optional<User> user = userDao.findById(id);
        User user_new = user.get();
        userDao.delete(user_new);
    }

}
