package com.poly.websitegaminggear.controller;

import com.poly.websitegaminggear.model.Category;
import com.poly.websitegaminggear.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    CategoryRepository categoryRepository;
    private String msg ="";

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Validated @RequestBody Category category) {
        try {
            categoryRepository.save(category);
            return new ResponseEntity<>("Save success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Thay bằng logging
            return new ResponseEntity<>("Save failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @Validated @RequestBody Category category) {
        try {
            if (categoryRepository.existsById(id)) { // kiểm tra id có tồn tại hay không
                category.setCategory_id(id);
                categoryRepository.save(category);
                return new ResponseEntity<>("Update success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Thay bằng logging
            return new ResponseEntity<>("Update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            if (categoryRepository.existsById(id)) { // kiểm tra id có tồn tại hay không
                categoryRepository.deleteById(id);
                return new ResponseEntity<>("Delete success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e

        ) {
            e.printStackTrace();
            return new ResponseEntity<>("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
