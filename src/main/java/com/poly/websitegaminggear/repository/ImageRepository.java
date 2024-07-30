package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.Category;
import com.poly.websitegaminggear.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}