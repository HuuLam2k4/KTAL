package com.poly.websitegaminggear.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int order_id;
    Date order_date;
    Double total_amount;
    Date updated_at;
    String username;
    // nối nhiều 1 với bảng order status
    @ManyToOne
    @JoinColumn(name = "status_id")
    OrderStatus status;
//  nốu 1 nhiều với bảng order item
    @OneToMany(mappedBy = "order")
    List<OrderItem> items;
}
