package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Address;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PaymentMethodDTO {
    private String address;
    private Long wardId;

    public Address toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(this, Address.class);
        return address;
    }

}
