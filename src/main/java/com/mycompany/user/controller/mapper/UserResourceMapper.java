/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.mapper;

import com.mycompany.user.controller.resource.UserResource;
import com.mycompany.user.model.User;

public final class UserResourceMapper {

    private UserResourceMapper(){
    }

    public static UserResource mapUserToUserResource(User user){
        UserResource userResource = new UserResource();
        userResource.setSsn(user.getSsn());
        userResource.setFirstname(user.getFirstname());
        userResource.setSurname(user.getSurname());
        userResource.setDob(user.getDob());
        userResource.setAddress(user.getAddress());
        userResource.setPostcode(user.getPostcode());
        userResource.setCity(user.getCity());
        userResource.setCountry(user.getCountry());
        return userResource;
    }

    public static User mapUserResourceToUser(UserResource userResource){
        User user = new User();
        user.setSsn(userResource.getSsn());
        user.setFirstname(userResource.getFirstname());
        user.setSurname(userResource.getSurname());
        user.setDob(userResource.getDob());
        user.setAddress(userResource.getAddress());
        user.setPostcode(userResource.getPostcode());
        user.setCity(userResource.getCity());
        user.setCountry(userResource.getCountry());
        return user;
    }
}
