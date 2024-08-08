package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private UserRepository userService;


    public List<User> getAllUser() {
        return userService.findAll();
    }


    public User getUserById(String username) {
        return userService.findById(username).orElse(null);
    }


    public User updateUser(String username, User userDetails) {
        User user = userService.findById(username).orElse(null);
        if (user != null) {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setAddress(userDetails.getAddress());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            return userService.save(user);
        }
        return null;
    }


    public void deleteUser(@PathVariable String username) {
        userService.deleteById(username);
    }


}
