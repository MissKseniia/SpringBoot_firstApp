package com.springboot.SpringBoot_firstApp.service;



import com.springboot.SpringBoot_firstApp.entity.User;

import java.util.List;

public interface UserService {

    void addOrUpdateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void removeUser(Long id);
}
