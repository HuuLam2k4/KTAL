package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
