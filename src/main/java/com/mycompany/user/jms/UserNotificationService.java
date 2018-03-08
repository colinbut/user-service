/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms;

import com.mycompany.user.dto.UserDto;

public interface UserNotificationService {
    void sendUserNotification(UserDto userDto);
}
