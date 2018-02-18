/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.controller.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity createUser() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok().build();
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
