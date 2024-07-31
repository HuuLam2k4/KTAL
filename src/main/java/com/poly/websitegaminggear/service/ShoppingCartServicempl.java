package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.controller.ShoppingCartRestController;
import com.poly.websitegaminggear.model.CartItem;
import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.repository.CartItemRepository;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ProductRepository;
import com.poly.websitegaminggear.repository.ShoppingCartRepository;
import com.poly.websitegaminggear.utils.SessionService;
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
    public ShoppingCart addToCart(int quantity, int productId, int cartItemId) {
        // kiem tra nguoi dung dang nhap
        if (sessionService.get("username") == null) {
            try {
                response.sendRedirect("/login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // kieemr tra su ton tai
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Khong cos gio hanfg"));
        ProductDetail productDetail = productDetailRepository.findById(productId).orElseThrow(() -> new RuntimeException("khong cos product"));

        Optional<CartItem> existingCartItem = shoppingCart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProductDetails().getProducts().getProduct_id() == productId)
                .findFirst();
        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuanlity(cartItem.getQuanlity() + quantity);
            cartItem.setUpdate_at(new Date());
            cartItemRepository.save(cartItem);
        } else {
            CartItem cartItem = new CartItem();
//            cartItem.setProductDetails();
            cartItem.setQuanlity(quantity);
            cartItem.setUpdate_at(new Date());
            cartItem.setShoppingCarts(shoppingCart);
            cartItemRepository.save(cartItem);
            shoppingCart.getCartItems().add(cartItem);
        }
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }


    @Override
    public void removeProduct(int product, int cartItem) {

    }

    @Override
    public List<CartItem> getCartItems() {
        return List.of();
    }

    @Override
    public BigDecimal getTotal() {
        return null;
    }
}
