/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
