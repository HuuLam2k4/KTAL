package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.*;
import com.poly.websitegaminggear.repository.CartItemRepository;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ProductRepository;
import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import com.poly.websitegaminggear.utils.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SessionService sessionService;


    public void addToCart(int quantity, Integer productDetailId) {
        User user = sessionService.get("user");
            ShoppingCart shoppingCart = shoppingCartRepository.findByUser(null).orElseGet(() -> {
                ShoppingCart newShoppingCart = new ShoppingCart();
                newShoppingCart.setUser(null);
                newShoppingCart.setCreatedAt(new Date());
                return shoppingCartRepository.save(newShoppingCart);
            });

            ProductDetail productDetail = productDetailRepository.findByProductDetailId(productDetailId)
                    .orElse(null);

            CartItem cartItem = cartItemRepository.findByShoppingCartAndProductDetail(shoppingCart, productDetail)
                    .orElseGet(() -> {
                        CartItem newCartItem = new CartItem();
                        newCartItem.setProductDetail(productDetail);
                        newCartItem.setShoppingCart(shoppingCart);
                        newCartItem.setQuantity(0);
                        return cartItemRepository.save(newCartItem);
                    });

            if (cartItem.getCartItemId() > 0) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemRepository.save(cartItem);
            }

    }


    public Product getProduct(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Collection<CartItem> getCartItems() {
        User user = sessionService.get("user");
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(null).orElse(null);
        return shoppingCart.getCartItems();
    }

    @Transactional
    public void removeCartItem(int cartItemId) {
        CartItem id = cartItemRepository.findById(cartItemId).orElse(null);
        cartItemRepository.delete(id);
    }
}
