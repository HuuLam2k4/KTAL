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
    private int order_id;
    private Date order_date;
    private  Double total_amount;
    private  Date updated_at;
    private String username;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> order_items;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;
}
