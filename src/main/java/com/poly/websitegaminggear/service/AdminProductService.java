package com.poly.websitegaminggear.service;

import com.poly.websitegaminggear.dto.ProductRequest;
import com.poly.websitegaminggear.model.Product;
import com.poly.websitegaminggear.model.ProductDetail;
import com.poly.websitegaminggear.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;

@Service
public class AdminProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private CapacityRepository capacityRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public Product createProduct(ProductRequest productRequest) {
        // Tạo đối tượng Product và ProductDetail
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setImageName(productRequest.getImageName());

        // Lấy Category nếu có
        if (productRequest.getCategoryId() != null) {
            categoryRepository.findById(productRequest.getCategoryId()).ifPresent(product::setCategory);
        }

        // Lấy Supplier nếu có
        if (productRequest.getSupplierId() != null) {
            supplierRepository.findById(productRequest.getSupplierId()).ifPresent(product::setSupplier);
        }

        // Lưu Product trước khi lưu ProductDetail
        Product savedProduct = productRepository.save(product);

        // Tạo và lưu ProductDetail
        ProductDetail productDetail = new ProductDetail();
        productDetail.setPrice(productRequest.getPrice());
        productDetail.setQuantity(productRequest.getQuantity());
        productDetail.setProduct(savedProduct);

        // Lấy Color nếu có
        if (productRequest.getColorId() != null) {
            colorRepository.findById(productRequest.getColorId()).ifPresent(productDetail::setColor);
        }

        // Lấy Capacity nếu có
        if (productRequest.getCapacityId() != null) {
            capacityRepository.findById(productRequest.getCapacityId()).ifPresent(productDetail::setCapacity);
        }

        productDetailRepository.save(productDetail);

        return savedProduct;
    }





    public Product updateProduct(Integer productId, String productName, String description, String imageName,
                                 Integer categoryId, double price, Integer quantity, Integer colorId,
                                 Integer capacityId, Integer supplierId) {
        // Tìm Product và ProductDetail liên quan
        Optional<Product> productOptional = productRepository.findById(productId);
        Optional<ProductDetail> productDetailOptional = productDetailRepository.findByProduct_ProductId(productId);

        if (productOptional.isPresent() && productDetailOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDetail productDetail = productDetailOptional.get();

            // Cập nhật Product
            product.setProductName(productName);
            product.setDescription(description);
            product.setImageName(imageName);

            if (categoryId != null) {
                categoryRepository.findById(categoryId).ifPresent(product::setCategory);
            }

            if (supplierId != null) {
                supplierRepository.findById(supplierId).ifPresent(product::setSupplier);
            }

            // Cập nhật ProductDetail
            productDetail.setPrice(price);
            productDetail.setQuantity(quantity);

            if (colorId != null) {
                colorRepository.findById(colorId).ifPresent(productDetail::setColor);
            }

            if (capacityId != null) {
                capacityRepository.findById(capacityId).ifPresent(productDetail::setCapacity);
            }

            // Lưu Product và ProductDetail
            productRepository.save(product);
            productDetailRepository.save(productDetail);

            return product;
        }

        return null; // Hoặc ném một ngoại lệ nếu cần
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public boolean deleteProduct(Integer productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
