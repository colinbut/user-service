/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.dao.UserDao;
import com.mycompany.user.dto.UserDto;
import com.mycompany.user.jms.UserEventService;
import com.mycompany.user.jms.UserNotificationService;
import com.mycompany.user.jms.event.UserEvent;
import com.mycompany.user.jms.event.UserEventType;
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
    private UserEventSender userEventSender;

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
        Mockito.verify(userDao, Mockito.times(1)).getUsers();
    }

    @Test
    public void testGetUser() throws Exception {
        User user = getUser();

        Mockito.when(userDao.getUser(SSN)).thenReturn(user);

        User actualUser = classInTest.getUser(SSN);

        assertEquals(user, actualUser);

        Mockito.verify(userDao, Mockito.times(1)).getUser(SSN);
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = getUser();

        Mockito.doNothing().when(userDao).saveUser(user);
        Mockito.doNothing().when(userNotificationService).sendUserNotification(Matchers.any(UserDto.class));
        Mockito.doNothing().when(userEventSender).sendUserEvent(Matchers.eq(UserEventType.CREATED), Matchers.any(UserDto.class));

        classInTest.createUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
        Mockito.verify(userNotificationService, Mockito.times(1)).sendUserNotification(Matchers.any(UserDto.class));
        Mockito.verify(userEventSender, Mockito.times(1)).sendUserEvent(Matchers.eq(UserEventType.CREATED), Matchers.any(UserDto.class));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = getUser();

        Mockito.doNothing().when(userDao).saveUser(user);
        Mockito.doNothing().when(userEventSender).sendUserEvent(Matchers.eq(UserEventType.UPDATED), Matchers.any(UserDto.class));

        classInTest.updateUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
        Mockito.verify(userEventSender, Mockito.times(1)).sendUserEvent(Matchers.eq(UserEventType.UPDATED), Matchers.any(UserDto.class));
    }

    @Test
    public void testDeleteUser() throws Exception {
        Mockito.doNothing().when(userDao).deleteUser(SSN);
        Mockito.doNothing().when(userEventSender).sendUserEvent(Matchers.eq(UserEventType.DELETED), Matchers.any(UserDto.class));

        classInTest.deleteUser(SSN);

        Mockito.verify(userDao, Mockito.times(1)).deleteUser(SSN);
        Mockito.verify(userEventSender, Mockito.times(1)).sendUserEvent(Matchers.eq(UserEventType.DELETED), Matchers.any(UserDto.class));
    }

}