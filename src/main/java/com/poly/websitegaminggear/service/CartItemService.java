package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.CartItem;
import com.poly.websitegaminggear.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItem(String id) {
        return cartItemRepository.findAll();
    }
}
