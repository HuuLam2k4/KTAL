package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    Optional<ProductDetail> findByProductDetailId(int productDetailId);
}
