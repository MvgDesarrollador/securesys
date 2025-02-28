package com.olimpusadonis.securesys.service.impl;

import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.User;
import com.olimpusadonis.securesys.model.mapstruct.MapperTool;
import com.olimpusadonis.securesys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository implements UserService {

    private final com.olimpusadonis.securesys.repository.UserRepository userRepository;
    private final MapperTool mapperTool;

    @Autowired
    public UserRepository(com.olimpusadonis.securesys.repository.UserRepository userRepository, MapperTool mapperTool){
        this.userRepository = userRepository;
        this.mapperTool = mapperTool;
    };

    @Override
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        User userEntity = mapperTool.userToEntity(userDTO);

        User response = userRepository.save(userEntity);
        if(response != null){
            return userDTO;
        } else{
            throw new RuntimeException("User cannot be created according to business rules");
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        return List.of();
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public String deleteUser() throws Exception {
        return "";
    }
}
