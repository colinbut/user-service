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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserEventSenderUTest {

    @Mock
    private UserEventService userEventService;

    @InjectMocks
    private UserEventSender classInTest = new UserEventSender();

    @Test
    public void testSendUserEvent(){
        Mockito.doNothing().when(userEventService).sendUserEvent(Matchers.any(UserEvent.class));

        classInTest.sendUserEvent(UserEventType.CREATED, new UserDto());

        Mockito.verify(userEventService, Mockito.times(1)).sendUserEvent(Matchers.any(UserEvent.class));

    }
}