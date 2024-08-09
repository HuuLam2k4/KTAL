package com.poly.websitegaminggear.service;


import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordChangeService {

    @Autowired
    private UserRepository userRepository;

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findById(username).orElse(null);

        if (user == null || !user.getPasswordHash().equals(oldPassword)) {
            return false;
        }

        user.setPasswordHash(newPassword);
        userRepository.save(user);
        return true;
    }
}
