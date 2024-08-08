package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;
    public List<ProductDetail> findAll() {return productDetailRepository.findAll();}
    public ProductDetail findProductDetailById(int id) {return productDetailRepository.findById(id).get();}
}
