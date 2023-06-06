package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Order;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
public class OrderCreateDTO {
    //private Date orderedDate;
//    private Date deliveredDate;
    private String orderStatus;
    private Long paymentMethodId;
    private Long createdUserId;
    private Long addressId;
    private Boolean isDelivered;

    public Order toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = modelMapper.map(this, Order.class);
        return order;
    }

}
