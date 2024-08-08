package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.repository.ProductDetailRepository;
import com.poly.websitegaminggear.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository productdtRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails, ProductDetail prodtuctDT) {
        Product product = productRepository.findById(id).orElse(null);
        ProductDetail productdt = productdtRepository.findById(id).orElse(null);
        if (product != null) {
            product.setProductName(productDetails.getProductName());
            return productRepository.save(product);
        }
        if (productdt != null) {
            productdt.setPrice(productdt.getPrice());
            return productdtRepository.save(productdt).getProduct();
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
