package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.dto.ProductRequest;
import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.service.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/productmanage")
public class AdminProductController {

    @Autowired
    private AdminProductService productService;

    // Hiển thị tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    // Hiển thị sản phẩm theo ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // Tạo sản phẩm mới
    @PostMapping
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        // Gọi service để tạo sản phẩm
        return productService.createProduct(productRequest);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(
                id,
                productRequest.getProductName(),
                productRequest.getDescription(),
                productRequest.getImageName(),
                productRequest.getCategoryId(),
                productRequest.getPrice(),
                productRequest.getQuantity(),
                productRequest.getColorId(),
                productRequest.getCapacityId(),
                productRequest.getSupplierId()
        );
    }

    // Xóa sản phẩm theo ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }


}
