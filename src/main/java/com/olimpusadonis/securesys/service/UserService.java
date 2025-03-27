package com.olimpusadonis.securesys.service;

import com.olimpusadonis.securesys.model.UserDTO;
import com.olimpusadonis.securesys.model.jpa.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser();
    User findByUserName(String username);

    //Functionalities
    UserDTO mapToDTO(User user);
}
