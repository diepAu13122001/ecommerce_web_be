package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Category;
import com.backend.ecommerceweb.entities.ProductCancel;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class CategoryService extends ABaseService {
    List<Category> findByName(String name){
        return categoryRepository.findByName(name);
    }
    List<Category> findByNameContaining(String name) {
        return categoryRepository.findByNameContaining(name);
    }
    List<Category> findByDescriptionContaining(String description){
        return findByDescriptionContaining(description);
    }
}
