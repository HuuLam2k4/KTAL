package com.poly.websitegaminggear.service;


import com.poly.websitegaminggear.model.*;
import com.poly.websitegaminggear.repository.CartItemRepository;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ProductRepository;
import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import com.poly.websitegaminggear.utils.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.http.HttpRequest;
import java.util.*;

@Service
@Transactional
public class ShoppingCartServicempl implements ShoppingCartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private HttpServletResponse response;


    @Override
    public ShoppingCart addToCart(int quantity, int productDetail) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByUsers(null);
        ShoppingCart cart = optionalCart.orElseGet(() -> {
            ShoppingCart newCart = new ShoppingCart();
            newCart.setCreate_at(new Date());
            newCart.setUpdate_at(new Date());
            return shoppingCartRepository.save(newCart);
        });
        return null;
    }
}
