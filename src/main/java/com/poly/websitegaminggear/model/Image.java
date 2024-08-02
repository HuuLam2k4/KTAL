package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @Column(unique = true, nullable = false)
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}