package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorId;
    @Column(nullable = false, unique = true)
    private String colorName;

    @OneToMany(mappedBy = "color")
    private List<ProductDetail> productDetails;
}