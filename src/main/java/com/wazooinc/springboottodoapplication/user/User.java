package com.wazooinc.springboottodoapplication.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User() {
        // Konstruktor default
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Object getPassword() {
        return null;
    }

    // Getter dan setter lainnya
}
