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
    String product_name;
    String description;
    Date created_at;
    Date updated_at;
    @OneToMany(mappedBy = "product")
    List<ProductDetail> productDetails;
    // Nối một nhiều bảng CartItem
    @OneToMany(mappedBy = "cart_item_id")
    List<Cart_Item> cartItems;
}
