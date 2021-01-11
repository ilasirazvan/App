package com.example.user.controller;

import com.example.user.dto.UserDTO;
import com.example.user.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registerUser(UserDTO userDTO) {
            return userService.registerUser(userDTO);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("id") String userId) {
        return userService.getUser(userId);
    }

    @POST
    @Path("/loginUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean login(UserDTO userDTO) {
        return userService.loginUser(userDTO);
    }
}
