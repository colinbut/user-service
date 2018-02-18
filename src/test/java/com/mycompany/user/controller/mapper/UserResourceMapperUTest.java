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

import static org.junit.Assert.*;

public class UserResourceMapperUTest {

    @Test
    public void testMapUserToUserResource() throws Exception {

        User user = UserTestHelper.getUser();

        UserResource userResource = UserResourceMapper.mapUserToUserResource(user);

        assertEquals("ssn", userResource.getSsn());
        assertEquals("firstname", userResource.getFirstname());
        assertEquals("surname", userResource.getSurname());
        assertEquals(new DateTime(2018, 1,1, 12, 0, 0).toDate(), userResource.getDob());
        assertEquals("postcode", userResource.getPostcode());
        assertEquals("Address", userResource.getAddress());
        assertEquals("City", userResource.getCity());
        assertEquals("Country", userResource.getCountry());

    }

    @Test
    public void testMapUserResourceToUser() throws Exception {

        UserResource userResource = UserTestHelper.getUserResource();

        User user = UserResourceMapper.mapUserResourceToUser(userResource);

        assertEquals("ssn", user.getSsn());
        assertEquals("firstname", user.getFirstname());
        assertEquals("surname", user.getSurname());
        assertEquals(new DateTime(2018, 1,1, 12, 0, 0).toDate(), user.getDob());
        assertEquals("postcode", user.getPostcode());
        assertEquals("Adress", user.getAddress());
        assertEquals("City", user.getCity());
        assertEquals("Country", user.getCountry());

    }

}