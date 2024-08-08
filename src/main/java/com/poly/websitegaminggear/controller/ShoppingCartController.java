//package com.poly.websitegaminggear.controller;
//
//import com.poly.websitegaminggear.model.ProductDetail;
//import com.poly.websitegaminggear.mpl.ShoppingCartServicempl;
//import com.poly.websitegaminggear.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class ShoppingCartController {
//    @Autowired
//    private ShoppingCartServicempl shoppingCartServicempl;
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/api/store")
//    public String getProduct(Model model) {
//        model.addAttribute("listProducts", productService.getAllProduct());
//        return "user/store";
//    }
//
//    @PostMapping("/api/store/add")
//    public String addToCart(@RequestParam int quantity, @RequestParam Integer productDetailId) {
//        try {
//            shoppingCartServicempl.addToCart(quantity, productDetailId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "user/shoppingcart";
//    }
//    @DeleteMapping("/api/store/remove")
//    public String removeFromCart(@RequestParam int productDetailId) {
//        shoppingCartServicempl.removeProductDetail(productDetailId);
//        return "user/shoppingcart";
//    }
//    @GetMapping("/api/shoppingcart")
//    public String getShoppingCart(Model model) {
//        model.addAttribute("carts", shoppingCartServicempl);
//        return "user/shoppingcart";
//    }
//}
