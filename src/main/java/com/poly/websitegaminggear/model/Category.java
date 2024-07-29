package com.poly.websitegaminggear.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    @Column(unique = true)
    @NotBlank(message = "{NotBlank.c.catergory_name}")
    String category_name;
    @NotBlank(message = "{NotBlank.c.description}")
    String description;
}
