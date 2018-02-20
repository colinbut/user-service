/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.mapper;

import com.mycompany.user.UserTestHelper;
import com.mycompany.user.controller.resource.UserResource;
import com.mycompany.user.model.User;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserResourceMapperUTest {

    @Test
    public void testMapUserToUserResource() throws Exception {

        User user = UserTestHelper.getUser();

        UserResource userResource = UserResourceMapper.mapUserToUserResource(user);

        assertEquals("###-0000-###-0001", userResource.getSsn());
        assertEquals("Firstname", userResource.getFirstname());
        assertEquals("Surname", userResource.getSurname());
        assertEquals(new DateTime(2018, 1,1, 12, 0, 0).toDate(), userResource.getDob());
        assertEquals("Postcode", userResource.getPostcode());
        assertEquals("Address", userResource.getAddress());
        assertEquals("City", userResource.getCity());
        assertEquals("Country", userResource.getCountry());

    }

    @Test
    public void testMapUserResourceToUser() throws Exception {

        UserResource userResource = UserTestHelper.getUserResource();

        User user = UserResourceMapper.mapUserResourceToUser(userResource);

        assertEquals("###-0000-###-0001", user.getSsn());
        assertEquals("Firstname", user.getFirstname());
        assertEquals("Surname", user.getSurname());
        assertEquals(new DateTime(2018, 1,1, 12, 0, 0).toDate(), user.getDob());
        assertEquals("Postcode", user.getPostcode());
        assertEquals("Address", user.getAddress());
        assertEquals("City", user.getCity());
        assertEquals("Country", user.getCountry());

    }

    @Test
    public void testMapUsersToUserResources() {
        List<User> users = new ArrayList<User>();

        User user1 = new User();
        user1.setSsn("no.1");
        user1.setFirstname("User 1 firstname");
        user1.setSurname("User 1 surname");
        user1.setDob(new DateTime(2018, 1,1,12,0,0).toDate());
        user1.setAddress("User 1 address");
        user1.setPostcode("User 1 postcode");
        user1.setCity("User 1 city");
        user1.setCountry("User 1 country");

        User user2 = new User();
        user2.setSsn("no.2");
        user2.setFirstname("User 2 firstname");
        user2.setSurname("User 2 surname");
        user2.setDob(new DateTime(2018, 1,3,12,0,0).toDate());
        user2.setAddress("User 2 address");
        user2.setPostcode("User 2 postcode");
        user2.setCity("User 2 city");
        user2.setCountry("User 2 country");

        users.add(user1);
        users.add(user2);

        List<UserResource> userResources = UserResourceMapper.mapUsersToUserResources(users);

        assertFalse(userResources.isEmpty());

        UserResource userResource1 = userResources.get(0);
        UserResource userResource2 = userResources.get(1);

        assertNotNull(userResource1);
        assertNotNull(userResource2);

        verifyUserMapped(user1, userResource1);
        verifyUserMapped(user2, userResource2);
    }

    @Test
    public void testMapUserResourcesToUsers() {
        List<UserResource> userResources = new ArrayList<UserResource>();

        UserResource userResource1 = new UserResource();
        userResource1.setSsn("no.1");
        userResource1.setFirstname("User 1 firstname");
        userResource1.setSurname("User 1 surname");
        userResource1.setDob(new DateTime(2018, 1,1,12,0,0).toDate());
        userResource1.setAddress("User 1 address");
        userResource1.setPostcode("User 1 postcode");
        userResource1.setCity("User 1 city");
        userResource1.setCountry("User 1 country");

        UserResource userResource2 = new UserResource();
        userResource2.setSsn("no.2");
        userResource2.setFirstname("User 2 firstname");
        userResource2.setSurname("User 2 surname");
        userResource2.setDob(new DateTime(2018, 1,3,12,0,0).toDate());
        userResource2.setAddress("User 2 address");
        userResource2.setPostcode("User 2 postcode");
        userResource2.setCity("User 2 city");
        userResource2.setCountry("User 2 country");

        userResources.add(userResource1);
        userResources.add(userResource2);

        List<User> users = UserResourceMapper.mapUserResourcesToUsers(userResources);

        assertFalse(users.isEmpty());

        User user1 = users.get(0);
        User user2 = users.get(1);

        assertNotNull(user1);
        assertNotNull(user2);

        verifyUserMapped(user1, userResource1);
        verifyUserMapped(user2, userResource2);
    }

    private void verifyUserMapped(User user, UserResource userResource){
        assertEquals(user.getSsn(), userResource.getSsn());
        assertEquals(user.getFirstname(), userResource.getFirstname());
        assertEquals(user.getSurname(), userResource.getSurname());
        assertEquals(user.getDob(), userResource.getDob());
        assertEquals(user.getAddress(), userResource.getAddress());
        assertEquals(user.getPostcode(), userResource.getPostcode());
        assertEquals(user.getCity(), userResource.getCity());
        assertEquals(user.getCountry(), userResource.getCountry());

    }

}