package com.olimpusadonis.securesys.model.mapstruct;

import com.olimpusadonis.securesys.model.RoleDTO;
import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.Role;
import com.olimpusadonis.securesys.model.jpa.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MapperTool {

    MapperTool INSTANCE = Mappers.getMapper(MapperTool.class);

    //User
    User userToEntity(UserDTO userDTO);
    UserDTO userToDTO(User user);

    //Role
    Role roleToEntity(RoleDTO roleDTO);
    RoleDTO roleToDTO(Role role);

}
