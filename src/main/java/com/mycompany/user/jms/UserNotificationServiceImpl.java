/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms;

import com.mycompany.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendUserNotification(UserDto userDto) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}
