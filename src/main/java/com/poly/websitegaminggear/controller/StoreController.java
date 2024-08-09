package com.poly.websitegaminggear.controller;


import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import com.poly.websitegaminggear.service.ProductService;
import com.poly.websitegaminggear.service.ShoppingCartService;
import com.poly.websitegaminggear.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoreController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/api/store")
    public String getProduct(Model model) {
        model.addAttribute("listProducts", productService.getAllProduct());
        return "user/store";
    }


}
