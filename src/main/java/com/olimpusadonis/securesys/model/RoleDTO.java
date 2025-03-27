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
public class RoleDTO {

    @Id
    private Integer roleId;

    private String roleName;

    private Date creationDate;

    private Date updateDate;
}
