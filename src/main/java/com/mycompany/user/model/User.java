/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class User {

    private String ssn;
    private String firstname;
    private String surname;
    private Date dob;
    private String email;
    private String address;
    private String postcode;
    private String city;
    private String country;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
            .append(ssn, user.ssn)
            .append(firstname, user.firstname)
            .append(surname, user.surname)
            .append(dob, user.dob)
            .append(email, user.email)
            .append(address, user.address)
            .append(postcode, user.postcode)
            .append(city, user.city)
            .append(country, user.country)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
            .append(ssn)
            .append(firstname)
            .append(surname)
            .append(dob)
            .append(email)
            .append(address)
            .append(postcode)
            .append(city)
            .append(country)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("ssn", ssn)
            .append("firstname", firstname)
            .append("surname", surname)
            .append("dob", dob)
            .append("email", email)
            .append("address", address)
            .append("postcode", postcode)
            .append("city", city)
            .append("country", country)
            .toString();
    }
}
