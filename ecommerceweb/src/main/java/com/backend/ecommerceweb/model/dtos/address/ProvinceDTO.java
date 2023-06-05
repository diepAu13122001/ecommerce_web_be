package com.backend.ecommerceweb.model.dtos.address;

import com.backend.ecommerceweb.entities.Province;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProvinceDTO {
    private String name;

    public Province toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Province province = modelMapper.map(this, Province.class);
        return province;
    }
}
