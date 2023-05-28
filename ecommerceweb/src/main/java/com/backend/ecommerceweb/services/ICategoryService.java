package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    List<Category> findByDescriptionContaining(String description);
}
