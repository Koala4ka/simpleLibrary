package com.library.service.impl;

import com.library.dao.UserDao;
import com.library.exception.LibraryServiceException;
import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void createUser(User user) {
     userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        userDao.findById(user.getId());
        if (user==null)
            throw new LibraryServiceException("Record with provided id is not found");
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        return userDao.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(User user) {
      userDao.delete(user);
    }

}
