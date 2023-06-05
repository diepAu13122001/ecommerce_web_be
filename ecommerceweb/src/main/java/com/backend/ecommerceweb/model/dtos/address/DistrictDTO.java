package com.backend.ecommerceweb.model.dtos.address;

import com.backend.ecommerceweb.entities.District;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DistrictDTO {
    private String name;
    private Long provinceId;

    public District toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        District district = modelMapper.map(this, District.class);
        return district;
    }

}
