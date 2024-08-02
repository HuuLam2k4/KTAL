package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Product_Detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productDetailId;

    private double price;

    private int quantity;

    private Date createdAt;

    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "capacity_id", nullable = false)
    private Capacity capacity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productDetail")
    private List<Review> reviews;

    @OneToMany(mappedBy = "productDetail")
    private List<CartItem> cartItems;
}