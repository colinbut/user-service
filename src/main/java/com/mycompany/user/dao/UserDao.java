/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.dao;

import com.mycompany.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUser(String ssn);

    void saveUser(User user);

    void deleteUser(String ssn);
}
