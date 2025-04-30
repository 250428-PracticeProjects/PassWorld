package com.example.PassWorld.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "credentials")
@Data
public class Credentials {

    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "site", nullable = false)
    private String site;


    
}
