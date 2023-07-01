package com.user.service.UserService.impl;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourceNotFoundException;
import com.user.service.UserService.repositories.UserRepository;
import com.user.service.UserService.services.UserService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        //to generate unique User Id for every entry.
        String randomUId = UUID.randomUUID().toString();
        user.setUserId(randomUId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("Resource not found for the id:"+ userId));
    }
}
