package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity     // tworzy encję i mapuje ją na tabele
public class User {
    @Id                                                     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto-inkrementacja
    private long userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
    private boolean status;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDateTime = LocalDateTime.now();
        this.status = true;
    }
}
