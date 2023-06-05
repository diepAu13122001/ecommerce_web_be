package com.backend.ecommerceweb.model.dtos.product;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Product;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProductDTO {
    private String name;
    private Long categoryId;
    private Double price;
    private Long supplierId;
    private Double cost;


    public Product toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(this, Product.class);
        return product;
    }

}
