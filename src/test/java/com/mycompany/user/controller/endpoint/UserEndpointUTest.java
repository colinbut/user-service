/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.endpoint;

import com.mycompany.user.UserTestHelper;
import com.mycompany.user.controller.mapper.UserResourceMapper;
import com.mycompany.user.model.User;
import com.mycompany.user.resource.UserResource;
import com.mycompany.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserResourceMapper.class})
public class UserEndpointUTest {

    private static final String SSN = "###-0000-###-0001";

    @Mock
    private UserService userService;

    @InjectMocks
    private UserEndpoint classInTest = new UserEndpoint();

    @Test
    public void testGetUsers() throws Exception {
        PowerMockito.mockStatic(UserResourceMapper.class);

        List<User> userList = new ArrayList<User>();
        userList.add(UserTestHelper.getUser());

        List<UserResource> userResourcesList = new ArrayList<UserResource>();
        userResourcesList.add(UserTestHelper.getUserResource());

        Mockito.when(userService.getUsers()).thenReturn(userList);
        PowerMockito.when(UserResourceMapper.mapUsersToUserResources(userList)).thenReturn(userResourcesList);

        ResponseEntity<?> responseEntity = classInTest.getUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userResourcesList, responseEntity.getBody());
    }

    @Test
    public void testCreateUser() throws Exception {
        PowerMockito.mockStatic(UserResourceMapper.class);

        UserResource userResource = new UserResource();
        User user = UserTestHelper.getUser();

        PowerMockito.when(UserResourceMapper.mapUserResourceToUser(userResource)).thenReturn(user);
        Mockito.doNothing().when(userService).createUser(user);

        ResponseEntity<?> responseEntity = classInTest.createUser(userResource);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).createUser(user);
        PowerMockito.verifyStatic(UserResourceMapper.class);
        UserResourceMapper.mapUserResourceToUser(userResource);
    }

    @Test
    public void testGetUser() throws Exception {

        User user = UserTestHelper.getUser();

        Mockito.when(userService.getUser(SSN)).thenReturn(user);

        ResponseEntity<?> responseEntity = classInTest.getUser(SSN);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        UserResource userResource = (UserResource) responseEntity.getBody();
        assertEquals(user.getSsn(), userResource.getSsn());
        assertEquals(user.getFirstname(), userResource.getFirstname());
        assertEquals(user.getSurname(), userResource.getSurname());
        assertEquals(user.getDob(), userResource.getDob());
        assertEquals(user.getAddress(), userResource.getAddress());
        assertEquals(user.getPostcode(), userResource.getPostcode());
        assertEquals(user.getCity(), userResource.getCity());
        assertEquals(user.getCountry(), userResource.getCountry());
    }

    @Test
    public void testDeleteUser() throws Exception {
        Mockito.doNothing().when(userService).deleteUser(SSN);

        classInTest.deleteUser(SSN);

        Mockito.verify(userService, Mockito.times(1)).deleteUser(SSN);
    }

    @Test
    public void testUpdateUser() throws Exception {
        PowerMockito.mockStatic(UserResourceMapper.class);

        UserResource userResource = new UserResource();
        User user = UserTestHelper.getUser();

        PowerMockito.when(UserResourceMapper.mapUserResourceToUser(userResource)).thenReturn(user);
        Mockito.doNothing().when(userService).updateUser(user);

        ResponseEntity<?> responseEntity = classInTest.updateUser(userResource);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).updateUser(user);
        PowerMockito.verifyStatic(UserResourceMapper.class);
        UserResourceMapper.mapUserResourceToUser(userResource);
    }

}