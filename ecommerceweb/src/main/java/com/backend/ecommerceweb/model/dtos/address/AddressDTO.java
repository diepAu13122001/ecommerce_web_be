package com.backend.ecommerceweb.model.dtos.address;

import com.backend.ecommerceweb.entities.Address;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AddressDTO {
    private String address;
    private Long wardId;

    public Address toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(this, Address.class);
        return address;
    }

}
