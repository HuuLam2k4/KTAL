package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping()
    public String getAll(Model moddel){
        List<Product> products = productRepository.findAll();
        moddel.addAttribute("products", products);
        return "user/product";
    }
}
