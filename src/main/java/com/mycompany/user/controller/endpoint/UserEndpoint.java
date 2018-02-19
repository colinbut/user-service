/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.endpoint;

import com.mycompany.user.controller.mapper.UserResourceMapper;
import com.mycompany.user.controller.resource.UserResource;
import com.mycompany.user.model.User;
import com.mycompany.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        List<User> users = userService.getUsers();


        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity createUser() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("userId") String ssn) {
        User user = userService.getUser(ssn);

        UserResource userResource = UserResourceMapper.mapUserToUserResource(user);

        return ResponseEntity.ok(userResource);
    }

    @RequestMapping(value = "/user/{userId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ResponseEntity updateUser() {
        return ResponseEntity.ok().build();
    }
}
