/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.service;

import com.mycompany.user.dto.UserDto;
import com.mycompany.user.jms.UserEventService;
import com.mycompany.user.jms.event.UserEvent;
import com.mycompany.user.jms.event.UserEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEventSender.class);

    @Autowired
    private UserEventService userEventService;

    public void sendUserEvent(UserEventType userEventType, UserDto userDto){
        UserEvent userEvent = new UserEvent();
        userEvent.setUserEventType(userEventType);
        userEvent.setUserDto(userDto);

        LOGGER.debug("Created UserEvent: {}", userEvent);

        LOGGER.info("Sending UserEvent: {}", userEvent);

        userEventService.sendUserEvent(userEvent);
    }
}
