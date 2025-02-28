package com.olimpusadonis.securesys.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Builder
@Entity(name = "ss_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Username", nullable = false, unique = true)
    private String userName;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "CreationDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "UpdateDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "isActive", nullable = true)
    private boolean isActive;

    // Getters and Setters managed by Lombok.

}
