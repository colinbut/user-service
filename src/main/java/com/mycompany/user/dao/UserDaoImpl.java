/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.mycompany.user.model.User;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String HOST = "127.0.0.1";

    private static final String SELECT_ALL_USERS_QUERY = "select * from userKS.users";
    private static final String SELECT_USER_WITH_SSN = "select * from userKS.users where ssn = ";

    private Cluster cluster = null;
    private Session session = null;

    @PostConstruct
    public void setUp(){
        cluster = Cluster.builder().addContactPoint(HOST).build();
        session = cluster.connect();
    }

    @PreDestroy
    public void tearDown() {
        if (cluster != null) {
            cluster.close();
        }
    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<User>();

        ResultSet rs = session.execute(SELECT_ALL_USERS_QUERY);

        for (Row row : rs) {
            User user = createUser(row);
            users.add(user);
        }

        return users;
    }

    @Override
    public User getUser(String ssn) {
        ResultSet rs = session.execute(SELECT_USER_WITH_SSN + ssn);
        Row row = rs.one();

        User user = createUser(row);

        return user;
    }

    @Override
    public void saveUser(User user) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    @Override
    public void deleteUser(String ssn) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    private User createUser(Row row) {
        User user = new User();
        user.setSsn(row.getString("ssn"));
        user.setFirstname(row.getString("forename"));
        user.setSurname(row.getString("surname"));

        LocalDate dateFromDB = row.getDate("dob");
        DateTime dateTime = new DateTime(dateFromDB.getYear(), dateFromDB.getMonth(), dateFromDB.getDay(), 0, 0, 0);

        user.setDob(dateTime.toDate());
        user.setAddress(row.getString("address"));
        user.setPostcode(row.getString("postcode"));
        user.setCity(row.getString("city"));
        user.setCountry(row.getString("country"));
        return user;
    }

}
