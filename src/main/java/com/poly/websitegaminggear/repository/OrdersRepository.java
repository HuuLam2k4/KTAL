package com.poly.websitegaminggear.repository;
import com.poly.websitegaminggear.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}

