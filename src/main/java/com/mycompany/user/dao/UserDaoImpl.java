/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.dao;

import com.mycompany.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    @Override
    public User getUser(int userId) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    @Override
    public void saveUser(User user) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    @Override
    public void deleteUser(int userId) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}
