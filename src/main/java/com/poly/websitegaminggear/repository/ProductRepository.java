package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
