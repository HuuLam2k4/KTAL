package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.repository.RoleRepository;
import com.poly.websitegaminggear.repository.UserRepository;
import com.poly.websitegaminggear.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserDetails toDetails(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
     ;
        String[] roles = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().getRoleName())
                .collect(Collectors.toList()).toArray(new String[0]);
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
//                .passwordEncoder(bCryptPasswordEncoder::encode)
                .password(password)
                .roles(roles)
                .build();
    }

    public UserDetails loadUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found");
        }
        User user = optionalUser.get();
        System.out.println("userservice username: "+username);
        System.out.println("userservice password: "+user.getPassword());
        System.out.println("userservice bCryptPasswordEncoder: "+bCryptPasswordEncoder);
        return toDetails(user);
    }
}
