package com.example.shop.model;

import jakarta.persistence.Entity;

@Entity
public class Provider {
    // data field
    private Integer id;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String email;
    private String password;
}
