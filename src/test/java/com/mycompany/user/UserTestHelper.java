/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user;

import com.mycompany.user.model.User;
import com.mycompany.user.resource.UserResource;
import org.joda.time.DateTime;

public final class UserTestHelper {

    private UserTestHelper() {
    }

    public static User getUser() {
        User user = new User();
        user.setSsn("###-0000-###-0001");
        user.setFirstname("Firstname");
        user.setSurname("Surname");
        user.setDob(new DateTime(2018, 1, 1, 12, 0, 0).toDate());
        user.setAddress("Address");
        user.setCity("City");
        user.setPostcode("Postcode");
        user.setCountry("Country");
        return user;
    }

    public static UserResource getUserResource() {
        UserResource userResource = new UserResource();
        userResource.setSsn("###-0000-###-0001");
        userResource.setFirstname("Firstname");
        userResource.setSurname("Surname");
        userResource.setDob(new DateTime(2018, 1, 1, 12, 0, 0).toDate());
        userResource.setAddress("Address");
        userResource.setCity("City");
        userResource.setPostcode("Postcode");
        userResource.setCountry("Country");
        return userResource;
    }
}
