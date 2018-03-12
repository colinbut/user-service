/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.dao.UserDao;
import com.mycompany.user.dto.UserDto;
import com.mycompany.user.jms.UserNotificationService;
import com.mycompany.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.user.UserTestHelper.getUser;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUTest {

    private static final String SSN = "###-0000-####-0001";

    @Mock
    private UserDao userDao;

    @Mock
    private UserNotificationService userNotificationService;

    @InjectMocks
    private UserServiceImpl classInTest = new UserServiceImpl();

    @Test
    public void testGetUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        users.add(getUser());

        Mockito.when(userDao.getUsers()).thenReturn(users);

        List<User> actualUsersList = classInTest.getUsers();

        assertEquals(users, actualUsersList);
    }

    @Test
    public void testSetUser() throws Exception {
        User user = getUser();

        Mockito.when(userDao.getUser(SSN)).thenReturn(user);
        Mockito.doNothing().when(userNotificationService).sendUserNotification(Matchers.any(UserDto.class));

        User actualUser = classInTest.getUser(SSN);

        assertEquals(user, actualUser);

        Mockito.verify(userDao, Mockito.times(1)).getUser(SSN);
        Mockito.verify(userNotificationService, Mockito.times(1)).sendUserNotification(Matchers.any(UserDto.class));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = getUser();

        Mockito.doNothing().when(userDao).saveUser(user);

        classInTest.createUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = getUser();

        Mockito.doNothing().when(userDao).saveUser(user);

        classInTest.updateUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        Mockito.doNothing().when(userDao).deleteUser(SSN);

        classInTest.deleteUser(SSN);

        Mockito.verify(userDao, Mockito.times(1)).deleteUser(SSN);
    }

}