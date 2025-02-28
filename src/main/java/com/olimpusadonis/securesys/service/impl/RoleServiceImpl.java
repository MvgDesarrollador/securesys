package com.olimpusadonis.securesys.service.impl;


import com.olimpusadonis.securesys.model.RoleDTO;
import com.olimpusadonis.securesys.model.jpa.Role;
import com.olimpusadonis.securesys.model.mapstruct.MapperTool;
import com.olimpusadonis.securesys.repository.RoleRespository;
import com.olimpusadonis.securesys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRespository roleRepository;
    private final MapperTool mapperTool;


    @Autowired
    public RoleServiceImpl(RoleRespository roleRepository, MapperTool mapperTool){
        this.roleRepository = roleRepository;
        this.mapperTool = mapperTool;
    };

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) throws Exception {

        Role response = roleRepository.save(mapperTool.roleToEntity(roleDTO));
        if(response != null){
            return roleDTO;
        } else{
            throw new RuntimeException("Role cannot be created according to business rules");
        }
    }

    @Override
    public List<Role> findAll() throws Exception {
        return List.of();
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO) throws Exception {
        return null;
    }

    @Override
    public String deleteRole() throws Exception {
        return "";
    }
}
