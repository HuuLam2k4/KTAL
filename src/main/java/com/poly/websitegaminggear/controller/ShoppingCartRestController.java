package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class ShoppingCartRestController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping()
    public String ShoppingCartRestController() {
        return "hello";
    }

    @PostMapping()
    public ResponseEntity<ShoppingCart> addProductToCart(@RequestBody int quantity, @RequestBody int productDetailId) {
        try {
            ShoppingCart updatedCart = shoppingCartService.addToCart(quantity, productDetailId);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
