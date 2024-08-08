package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.service.ShoppingCartService;
import com.poly.websitegaminggear.repository.CartItemRepository;
import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import com.poly.websitegaminggear.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/store")
public class ShoppingCartRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartServicempl;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("")
    public List<Product> getProductDetails() {
        return productService.getAllProduct();
    }

    @GetMapping("{cartId}")
    public ShoppingCart getShoppingCartById(@PathVariable int cartId) {
        return shoppingCartRepository.findById(cartId).orElse(null);
    }
    @PostMapping("/add-to-cart")
    public ResponseEntity<Void> addToCart(@RequestParam int quantity, @RequestParam Integer productDetailId) {
        shoppingCartServicempl.addToCart(quantity, productDetailId);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/cart")
    public ResponseEntity<List<ShoppingCart>> getCart() {
        List<ShoppingCart> shoppingCarts = shoppingCartServicempl.getCart();
        return ResponseEntity.ok(shoppingCarts);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeProductDetail(@PathVariable int id) {
        shoppingCartServicempl.removeCartItem(id);
        return ResponseEntity.ok().build();
    }

}
