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
    private int order_item_id;
    private Date order_date;
    private int quantity = 1;
    private Double price;
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "productDetails")
    private ProductDetail productDetails;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order orders;

}