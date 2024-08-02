package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(unique = true, nullable = false)
    private String supplierName;

    private String description;

    @OneToMany(mappedBy = "supplier")
    private List<Category> categories;
}