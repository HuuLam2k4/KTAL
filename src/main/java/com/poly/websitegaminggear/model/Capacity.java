package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
