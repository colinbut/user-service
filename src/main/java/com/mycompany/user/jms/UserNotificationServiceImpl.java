/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms;

import com.mycompany.user.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(UserNotificationServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendUserNotification(final UserDto userDto) {

        LOG.info("Sending user notification message to Notification Service via JMS");

        jmsTemplate.convertAndSend(userDto, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
                message.setJMSCorrelationID(userDto.getSsn());
                return message;
            }
        });
    }
}
