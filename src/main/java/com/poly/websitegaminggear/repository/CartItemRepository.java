package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
