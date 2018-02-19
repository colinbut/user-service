/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.dao.UserDao;
import com.mycompany.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(String ssn) {
        return userDao.getUser(ssn);
    }

    @Override
    public void createUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(String ssn) {
        userDao.deleteUser(ssn);
    }
}
