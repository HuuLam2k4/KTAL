package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
