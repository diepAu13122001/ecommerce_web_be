package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    List<Category> findByDescriptionContaining(String description);


}
