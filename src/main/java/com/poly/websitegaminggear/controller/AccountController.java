package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.repository.UserRepository;
import com.poly.websitegaminggear.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService userService;

    @GetMapping
    public List<User> getAllStudents() {
        return userService.getAllUser();
    }

    @GetMapping("/{username}")
    public User getUserById(@PathVariable String username) {
        return userService.getUserById(username);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User userDetails) {
        return userService.updateUser(username, userDetails);
    }

    @DeleteMapping("/{username}")
    public void deleteStudent(@PathVariable String username) {
        userService.deleteUser(username);
    }



}
