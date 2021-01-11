package com.example.user.service;

import com.example.user.dao.UserDAO;
import com.example.user.dto.UserDTO;
import com.example.user.entity.UserAccount;
import com.example.user.util.PasswordEncoder;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

    @Inject
    UserDAO userDAO;

    ModelMapper modelMapper = new ModelMapper();

    PasswordEncoder passwordEncoder = PasswordEncoder.getInstance();

    public List<UserDTO> getUsers() {
        return userDAO.getUsers()
                .stream()
                .map(userAccount -> modelMapper.map(userAccount, UserDTO.class))
                .collect(Collectors.toList());
    }

    public boolean registerUser(UserDTO userDTO) {
        userDTO.setId(UUID.randomUUID().toString());
        if (userDTO.getPassword().equals("")) {
            throw new RuntimeException("Password was not set");
        }
        if (userDAO.getUserByUsername(userDTO.getUsername()) != null) {
            throw new RuntimeException("Username is in use. Please provide another username");
        }
        userDTO.setPassword(passwordEncoder.encodePassword(userDTO.getPassword()));
        return userDAO.registerUser(modelMapper.map(userDTO, UserAccount.class));
    }

    public UserDTO getUser(String userId) {
        return modelMapper.map(userDAO.getUser(userId), UserDTO.class);
    }

    public boolean loginUser(UserDTO userDTO) {
        return passwordEncoder.decodePassword(userDTO.getPassword(), userDAO.getUserByUsername(userDTO.getUsername()).getPassword());
    }
}
