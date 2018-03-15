/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms;

import com.mycompany.user.jms.event.UserEvent;

public interface UserEventService {
    void sendUserEvent(UserEvent userEvent);
}
