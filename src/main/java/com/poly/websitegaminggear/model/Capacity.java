package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Capacity")
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capacity_id;
    @Column(unique = true, nullable = false)
    private String capacity_name;

    @OneToMany(mappedBy = "capacity")
    private List<ProductDetail> productsDetails;

}
