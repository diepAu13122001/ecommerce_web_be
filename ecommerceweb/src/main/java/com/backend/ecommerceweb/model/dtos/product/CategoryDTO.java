package com.backend.ecommerceweb.model.dtos.product;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Category;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CategoryDTO {
    private String name;
    private String description;

    public Category toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(this, Category.class);
        return category;
    }

}
