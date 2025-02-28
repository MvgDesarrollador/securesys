package com.olimpusadonis.securesys.service;

import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll() throws Exception;
    UserDTO createUser(UserDTO userDTO) throws Exception;
    UserDTO updateUser(UserDTO userDTO) throws Exception;
    String deleteUser() throws Exception;
}
