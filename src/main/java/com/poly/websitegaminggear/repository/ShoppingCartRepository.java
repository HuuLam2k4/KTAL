package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.ShoppingCart;
import com.poly.websitegaminggear.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findByUsers(User user);
}
