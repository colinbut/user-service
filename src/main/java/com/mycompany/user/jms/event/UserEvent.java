/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.jms.event;

import com.mycompany.user.dto.UserDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserEvent {
    private UserEventType userEventType;
    private UserDto userDto;

    public UserEventType getUserEventType() {
        return userEventType;
    }

    public void setUserEventType(UserEventType userEventType) {
        this.userEventType = userEventType;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserEvent userEvent = (UserEvent) o;

        return new EqualsBuilder()
            .append(userEventType, userEvent.userEventType)
            .append(userDto, userEvent.userDto)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(userEventType)
            .append(userDto)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("userEventType", userEventType)
            .append("userDto", userDto)
            .toString();
    }
}
