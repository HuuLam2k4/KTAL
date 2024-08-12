package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.User;
import com.poly.websitegaminggear.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";  // Assuming there's a signup.html template
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        User registeredUser = signUpService.registerUser(user);
        model.addAttribute("user", registeredUser);
        return "signup_success";  // Assuming there's a signup_success.html template
    }
}
