package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository <OrderItem, Integer> {

}


