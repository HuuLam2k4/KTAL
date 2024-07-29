package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     int category_id;
    String category_name;
    String description;
}
