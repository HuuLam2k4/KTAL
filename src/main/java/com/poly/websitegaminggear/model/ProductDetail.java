package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_detail_id;
    private double price;
    private int quanlity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    @ManyToOne
    @JoinColumn(name = "capacity_id")
    private Capacity capacity;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

}
