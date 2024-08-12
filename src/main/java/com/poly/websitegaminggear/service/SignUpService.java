package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.Role;
import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.model.UserRole;
import com.poly.websitegaminggear.repository.RoleRepository;
import com.poly.websitegaminggear.repository.UserRepository;
import com.poly.websitegaminggear.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User registerUser(User user) {
        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Assign the role with ID 2 to the user
        Role role = roleRepository.findById(2).orElseThrow(() -> new RuntimeException("Role not found"));
        UserRole userRole = new UserRole();
        userRole.setUser(savedUser);
        userRole.setRole(role);

        // Save the user role
        userRoleRepository.save(userRole);

        return savedUser;
    }
}
