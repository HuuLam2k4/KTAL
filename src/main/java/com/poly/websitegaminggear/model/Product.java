package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int product_id;
    @Column(unique = true, nullable = false)
    private String product_name;
    private String description;
    private Date created_at;
    private Date updated_at;


    @ManyToOne
    @JoinColumn(name = "products")
    private Category category;

    @OneToMany(mappedBy = "products")
    private List<ProductDetail> product_details;

    @OneToMany(mappedBy = "products")
    private List<Image> images;

    @OneToMany(mappedBy = "products")
    private List<Review> reviews;

    @OneToMany(mappedBy = "products")
    private List<OrderItem> order_items;

    @OneToMany(mappedBy = "products")
    private List<CartItem> cart_items;
}
