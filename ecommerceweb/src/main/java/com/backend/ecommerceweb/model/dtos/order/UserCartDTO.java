package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.UserCart;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UserCartDTO {

    private int productAmount;
//    private Long giftId;
    private Long userId;

    public UserCart toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        UserCart userCart = modelMapper.map(this, UserCart.class);
        return userCart;
    }

}
