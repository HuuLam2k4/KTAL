package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.CartItem;
import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addToCart(int quantity, int product, int cartItem );
    void removeProduct(int product, int cartItem );
    List<CartItem> getCartItems();
    BigDecimal getTotal();

}
