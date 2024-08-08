package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.CartItem;
import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.repository.CartItemRepository;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void addToCart(int quantity, Integer productDetailId) {
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


    public List<ShoppingCart> getCart() {
        return shoppingCartRepository.findAll();
    }


    public void getToltalAmount(double totalAmout) {

    }

    @Transactional
    public void removeCartItem(int cartItemId) {
        CartItem id = cartItemRepository.findById(cartItemId).orElse(null);
        cartItemRepository.delete(id);
    }
}
