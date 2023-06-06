package com.backend.ecommerceweb.model.dtos.product;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.ProductDescription;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
public class ProductDescriptionDTO {
    private String productStorageTemp; //nhiet do bao quan ???
    private Date expiryDate; // ngay san xuat
    private Date manufacturingDate; // ngay het han
    private Double productWeigh;
    private String productDes;


    public ProductDescription toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        ProductDescription productDescription = modelMapper.map(this, ProductDescription.class);
        return productDescription;
    }

}
