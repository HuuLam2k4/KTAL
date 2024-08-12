package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService UserService;
//CRUD
    @GetMapping("")
    public List<User> getAllUser() {
        return UserService.getAllUser();
    }

    @GetMapping("/{username}")
    public User getUserById(@PathVariable String username) {
        return UserService.getUserByID(username);
    }

    @PostMapping
    public User createStudent(@Valid @RequestBody User user) {
        return UserService.createUser(user);
    }

    @PutMapping("/{username}")
    public User updateUser(@Valid @PathVariable String username, @RequestBody User userDetails) {
        return UserService.updateUser(username, userDetails);
    }

    @DeleteMapping("/{username}")
    public void deleteStudent(@PathVariable String username) {
        UserService.deleteUser(username);
    }

//Đổi mật khẩu
    @PutMapping("/{username}/change-password")
    public User changePassword(@PathVariable String username, @RequestBody String newPassword) {
        return UserService.changePassword(username, newPassword);
    }

//Quên mật khẩu
    @PostMapping("/send-otp")
    public void sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        UserService.sendOtp(email);
    }

    @PostMapping("/verify-otp")
    public boolean verifyOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");
        return UserService.verifyOtp(email, otp);
    }


    @PostMapping("/change-password")
    public User changePassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");
        String newPassword = request.get("newPassword");
        return UserService.changePassword(email, otp, newPassword);
    }
}
