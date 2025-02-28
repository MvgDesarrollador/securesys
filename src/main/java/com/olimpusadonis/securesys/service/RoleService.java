package com.olimpusadonis.securesys.service;

import com.olimpusadonis.securesys.model.RoleDTO;
import com.olimpusadonis.securesys.model.jpa.Role;

import java.util.List;


public interface RoleService {

    List<Role> findAll() throws Exception;
    RoleDTO createRole(RoleDTO roleDTO) throws Exception;
    RoleDTO updateRole(RoleDTO roleDTO) throws Exception;
    String deleteRole() throws Exception;
}
