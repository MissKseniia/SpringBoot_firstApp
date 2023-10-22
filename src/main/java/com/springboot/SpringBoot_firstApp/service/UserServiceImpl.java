package com.springboot.SpringBoot_firstApp.service;

import com.springboot.SpringBoot_firstApp.dao.UserDao;
import com.springboot.SpringBoot_firstApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLDataException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addOrUpdateUser(User user) {
        userDao.addOrUpdateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        try {
            userDao.removeUser(id);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
    }
}
