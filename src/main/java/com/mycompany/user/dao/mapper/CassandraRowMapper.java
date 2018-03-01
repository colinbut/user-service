/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.dao.mapper;

import com.datastax.driver.core.Row;
import com.mycompany.user.model.User;

public interface CassandraRowMapper {
    User mapRow(Row row);
}
