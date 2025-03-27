package com.olimpusadonis.securesys.service.impl;

import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.User;
import com.olimpusadonis.securesys.model.mapstruct.MapperTool;
import com.olimpusadonis.securesys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.olimpusadonis.securesys.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final com.olimpusadonis.securesys.repository.UserRepository userRepository;
    private final MapperTool mapperTool;

    @Autowired
    public UserServiceImpl(com.olimpusadonis.securesys.repository.UserRepository userRepository, MapperTool mapperTool){
        this.userRepository = userRepository;
        this.mapperTool = mapperTool;
    };

    @Override
    public UserDTO createUser(UserDTO userDTO){
        User userEntity = mapperTool.userToEntity(userDTO);
        User response = userRepository.save(userEntity);
        if(response != null){
            return userDTO;
        } else{
            throw new IllegalArgumentException("The User cannot be null");
        }
    }

    @Override
    public UserDTO mapToDTO(User user){
        return mapperTool.userToDTO(user);
    }

    @Override
    public User findByUserName(String username){
        Optional<User> user = userRepository.findByUserName(username);
        if (!user.isPresent()){
            throw new UserNotFoundException("User not found by the username ");
        }
        User userReturn = user.get();
        return userReturn;
    }

    @Override
    public List<User> findAll(){
        return List.of();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO){
        return null;
    }

    @Override
    public String deleteUser(){
        return "";
    }

}
