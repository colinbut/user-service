/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.user.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {
    private String firstlineAddress;
    private String secondlineAddress;
    private String postcode;
    private String city;
    private String country;

    public String getFirstlineAddress() {
        return firstlineAddress;
    }

    public void setFirstlineAddress(String firstlineAddress) {
        this.firstlineAddress = firstlineAddress;
    }

    public String getSecondlineAddress() {
        return secondlineAddress;
    }

    public void setSecondlineAddress(String secondlineAddress) {
        this.secondlineAddress = secondlineAddress;
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
}
