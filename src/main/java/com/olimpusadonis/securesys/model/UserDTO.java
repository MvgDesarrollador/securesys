package com.olimpusadonis.securesys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class UserDTO {

    @Id
    private Integer userId;

    private String username;

    private String passwordHash;

    private String email;

    private Date creationDate;

    private Date updateDate;

    private boolean isActive;

}
