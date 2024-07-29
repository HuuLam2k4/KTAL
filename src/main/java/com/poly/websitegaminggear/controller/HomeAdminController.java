package com.poly.websitegaminggear.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class HomeAdminController {

    @GetMapping("/home")
    public String home(Model model) {

        return "Home";
    }
}
