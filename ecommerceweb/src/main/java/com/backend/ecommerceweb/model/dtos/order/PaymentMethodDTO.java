package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.PaymentMethod;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PaymentMethodDTO {
    private String name;
    private String imgUrl;
    private Double minTransfer;
    private Double maxTransfer;

    public PaymentMethod toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        PaymentMethod paymentMethod = modelMapper.map(this, PaymentMethod.class);
        return paymentMethod;
    }

}
