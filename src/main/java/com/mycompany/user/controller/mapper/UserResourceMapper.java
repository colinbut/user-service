/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.mapper;

import com.mycompany.user.model.User;
import com.mycompany.user.resource.UserResource;

import java.util.ArrayList;
import java.util.List;

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

    public static List<UserResource> mapUsersToUserResources(List<User> users) {
        List<UserResource> userResources = new ArrayList<UserResource>();
        for (User user : users){
            userResources.add(mapUserToUserResource(user));
        }
        return userResources;
    }

    public static List<User> mapUserResourcesToUsers(List<UserResource> userResources) {
        List<User> users = new ArrayList<User>();
        for (UserResource userResource : userResources) {
            users.add(mapUserResourceToUser(userResource));
        }
        return users;
    }
}
