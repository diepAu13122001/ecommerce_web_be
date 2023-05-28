package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.Shipper;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class ShipperDTO {
    private String name;
    private String phone;
    private String gender;
    private String orderNumber;

    public Shipper toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Shipper shipper = modelMapper.map(this, Shipper.class);
        return shipper;
    }

}
