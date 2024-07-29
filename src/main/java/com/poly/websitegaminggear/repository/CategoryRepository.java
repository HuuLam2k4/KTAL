package com.poly.websitegaminggear.repository;

import com.poly.websitegaminggear.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
