package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Category;
import com.backend.ecommerceweb.services.impl.CategoryService;

import java.util.List; 

public interface ICategoryService {
    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    List<Category> findByDescriptionContaining(String description);
    List<Category> findAll();
    List<Category> findAllByOrderByNameAsc();
    List<Category> findAllByOrderByIdAsc();
    Category createCategory(Category category);
    void deleteById(Long id);
    Category findById(Long id);
}
