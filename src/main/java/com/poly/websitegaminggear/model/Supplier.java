package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;
    @Column(unique = true, nullable = false)
    private String supplier_name;
    private String description;

    @OneToMany(mappedBy = "supplier")
    private List<Category_Supplier> categorySuppliers;
}
