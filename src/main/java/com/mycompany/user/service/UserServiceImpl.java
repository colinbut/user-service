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
import com.mycompany.user.jms.event.UserEventType;
import com.mycompany.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserEventSender userEventSender;

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

        UserDto userDto = mapUserToUserDto(user);

        // TODO atm just notify on user creation
        // but ideally use this notification mechanism for some more advanced complex business process
        userNotificationService.sendUserNotification(userDto);

        userEventSender.sendUserEvent(UserEventType.CREATED, userDto);
    }


    @Override
    public void updateUser(User user) {
        userDao.saveUser(user);

        UserDto userDto = mapUserToUserDto(user);

        userEventSender.sendUserEvent(UserEventType.UPDATED, userDto);
    }

    @Override
    public void deleteUser(String ssn) {
        User user = userDao.getUser(ssn);

        userDao.deleteUser(ssn);

        UserDto userDto = mapUserToUserDto(user);

        userEventSender.sendUserEvent(UserEventType.DELETED, userDto);
    }

    private UserDto mapUserToUserDto(User user) {
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
        return userDto;
    }

}
