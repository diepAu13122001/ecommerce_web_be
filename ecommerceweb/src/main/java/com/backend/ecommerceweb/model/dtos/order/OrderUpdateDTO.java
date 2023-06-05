package com.backend.ecommerceweb.model.dtos.order;

import com.backend.ecommerceweb.entities.Order;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;
@Data
public class OrderUpdateDTO {
    private Date updatedDate;
    private Date deliveredDate;
    private String orderStatus;
    private Long updateUserId;
    private Boolean isDelivered;
    private Long shipperId;

    public Order toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = modelMapper.map(this, Order.class);
        return order;
    }
}
