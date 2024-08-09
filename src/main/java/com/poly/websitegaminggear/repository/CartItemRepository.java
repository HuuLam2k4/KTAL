package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.CartItem;
import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByShoppingCartAndProductDetail(ShoppingCart shoppingCart, ProductDetail productDetail);

}
