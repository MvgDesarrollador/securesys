package com.olimpusadonis.securesys.model;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class UserDTO {

    private Integer userId;

    private String username;

    private String passwordHash;

    private String email;

    private Date creationDate;

    private Date updateDate;

    private boolean isActive;

}
