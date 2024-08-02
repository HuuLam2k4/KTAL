package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Shopping_Cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItems;
}