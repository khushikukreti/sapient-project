package com.sapient.flixme.entity;

import lombok.Data;

@Data
public class Admin {
    private  Integer id;
    private String name;
    private String email;
    private String password;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String country;
}
