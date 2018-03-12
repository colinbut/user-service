/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.dao.UserDao;
import com.mycompany.user.dto.AddressDto;
import com.mycompany.user.dto.UserDto;
import com.mycompany.user.jms.UserNotificationService;
import com.mycompany.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserNotificationService userNotificationService;

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

        UserDto userDto = new UserDto();
        userDto.setSsn(user.getSsn());
        userDto.setFirstname(user.getFirstname());
        userDto.setSecondname(user.getSurname());
        userDto.setDob(user.getDob());

        AddressDto addressDto = new AddressDto();
        addressDto.setFirstlineAddress(user.getAddress());
        addressDto.setPostcode(user.getPostcode());
        addressDto.setCity(user.getCity());
        addressDto.setCountry(user.getCountry());

        userDto.setAddress(addressDto);

        userNotificationService.sendUserNotification(userDto);
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
