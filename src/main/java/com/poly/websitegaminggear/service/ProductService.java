package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct () {
        return productRepository.findAll();
    }

}
