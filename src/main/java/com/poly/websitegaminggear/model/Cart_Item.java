package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cart_Items")
public class Cart_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cart_item_id;
    int quanlity;
    Date update_at;
    //Nối nhìu một Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
