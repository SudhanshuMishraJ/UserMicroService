package com.user.service.UserService.services;

import com.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    //Create
    User saveUser(User user);

    //Get All user
    List<User> getAllUser();

    //Get User by ID
    User getUser(String userId);


}
