package com.olimpusadonis.securesys.service;

import com.olimpusadonis.securesys.model.RoleDTO;
import com.olimpusadonis.securesys.model.jpa.Role;

import java.util.List;


public interface RoleService {

    List<Role> findAll();
    RoleDTO createRole(RoleDTO roleDTO);
    RoleDTO updateRole(RoleDTO roleDTO);
    String deleteRole();
}
