/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms.impl;

import com.mycompany.user.jms.UserEventService;
import com.mycompany.user.jms.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventServiceImpl implements UserEventService {

    @Autowired
    @Qualifier("userEventJmsTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public void sendUserEvent(UserEvent userEvent) {
        throw new UnsupportedOperationException("Panic");
    }
}
