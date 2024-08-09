package com.poly.websitegaminggear.controller;


import com.poly.websitegaminggear.service.PasswordChangeService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ChangePasswordController {
    @Autowired
    private PasswordChangeService passwordChangeService;

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(Authentication authentication, @RequestParam String oldPassword, @RequestParam String newPassword) {
        String username = authentication.name();

        boolean isPasswordChanged = passwordChangeService.changePassword(username, oldPassword, newPassword);

        if (!isPasswordChanged) {
            return ResponseEntity.badRequest().body("Old password is incorrect or user not found.");
        }

        return ResponseEntity.ok("Password changed successfully.");
    }

}
