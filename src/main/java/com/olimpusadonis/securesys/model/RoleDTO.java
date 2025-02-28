package com.olimpusadonis.securesys.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoleDTO {

    private Integer roleId;

    private String roleName;

    private Date creationDate;

    private Date updateDate;
}
