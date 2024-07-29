package com.poly.websitegaminggear.repository;


import com.poly.websitegaminggear.model.OrderStatuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderStatusesRepository extends JpaRepository<OrderStatuses, Integer> {
}
