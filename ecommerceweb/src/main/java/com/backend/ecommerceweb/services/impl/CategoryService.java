package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Category;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends ABaseService implements ICategoryService {

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findByNameContaining(String name) {
        return categoryRepository.findByNameContaining(name);
    }

    @Override
    public List<Category> findByDescriptionContaining(String description) {
        return categoryRepository.findByDescriptionContaining(description);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllByOrderByNameAsc() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Category> findAllByOrderByIdAsc() {
        return categoryRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> c = categoryRepository.findById(id);
        return c.isPresent() == false ? null : c.get();
    }

}
