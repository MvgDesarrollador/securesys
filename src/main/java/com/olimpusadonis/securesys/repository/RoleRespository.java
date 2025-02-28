package com.olimpusadonis.securesys.repository;


import com.olimpusadonis.securesys.model.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRespository extends JpaRepository<Role, Integer> {
    List<Role> findAll();

    Role save(Role role);

    Role findByRoleId(Integer roleId);

    Role findByRoleName(String roleName);
}
