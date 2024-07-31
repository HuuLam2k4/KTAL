package com.poly.websitegaminggear.repository;


import com.poly.websitegaminggear.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusesRepository extends JpaRepository<OrderStatus, Integer> {
}
