package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_Items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int order_id;
    Date order_date;
    int quantity;
    Double price;
    Date updated_at;
//    Nối nhiều 1 với bảng order
    @ManyToOne
    @JoinColumn(name ="order_id")
    Order order;
}