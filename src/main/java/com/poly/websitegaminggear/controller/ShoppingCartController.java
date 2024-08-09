package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.service.ProductService;
import com.poly.websitegaminggear.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    @GetMapping("/api/cart")
    public String getShoppingCart(Model model) {
        model.addAttribute("carts", shoppingCartService.getCartItems());
        return "user/shoppingcart";
    }

    @PostMapping("/api/store/add")
    public String addToCart(@RequestParam int quantity, @RequestParam Integer productDetailId) {
        try {
            shoppingCartService.addToCart(quantity, productDetailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/api/cart";
    }

    @PostMapping("/api/removeCart/{cartItemId}")
    public String removeFromCart(@PathVariable int cartItemId) {
        shoppingCartService.removeCartItem(cartItemId);
        return "forward:/api/cart";
    }

}
