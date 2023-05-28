package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class OrderService extends ABaseService{
    List<Order> findByOrderedDate(Date orderedDate){
        return orderRepository.findByOrderedDate(orderedDate);
    }

    List<Order> findByOrderedDateGreaterThanEqual(Date orderedDate){
        return orderRepository.findByOrderedDateGreaterThanEqual(orderedDate);
    }

    List<Order> findByOrderedDateLessThanEqual(Date orderedDate){
        return orderRepository.findByOrderedDateLessThanEqual(orderedDate);
    }

    List<Order> findByOrderedDateBetween(Date started, Date ended){
        return orderRepository.findByOrderedDateBetween(started, ended);
    }

    List<Order> findByDeliveredDate(Date deliveredDate){
        return orderRepository.findByDeliveredDate(deliveredDate);
    }

    List<Order> findByDeliveredDateGreaterThanEqual(Date deliveredDate){
        return orderRepository.findByDeliveredDateGreaterThanEqual(deliveredDate);
    }

    List<Order> findByDeliveredDateLessThanEqual(Date deliveredDate){
        return orderRepository.findByDeliveredDateLessThanEqual(deliveredDate);
    }

    List<Order> findByDeliveredDateBetween(Date started, Date ended){
        return orderRepository.findByDeliveredDateBetween(started, ended);
    }

    List<Order> findByUpdatedDate(Date updatedDate){
        return orderRepository.findByUpdatedDate(updatedDate);
    }

    List<Order> findByUpdatedDateGreaterThanEqual(Date updatedDate){
        return orderRepository.findByUpdatedDateGreaterThanEqual(updatedDate);
    }

    List<Order> findByUpdatedDateLessThanEqual(Date updatedDate){
        return orderRepository.findByUpdatedDateLessThanEqual(updatedDate);
    }

    List<Order> findByUpdatedDateBetween(Date started, Date ended){
        return orderRepository.findByUpdatedDateBetween(started, ended);
    }

    List<Order> findByOrderStatus(String status){
        return orderRepository.findByOrderStatus(status);
    }

    List<Order> findByPaymentMethod(Long methodId){
        return orderRepository.findByPaymentMethod(methodId);
    }

    List<Order> findByCreatedUser(Long userId){
        return orderRepository.findByCreatedUser(userId);
    }

    List<Order> findByUpdatedUser(Long userId){
        return orderRepository.findByUpdatedUser(userId);
    }

    List<Order> findByAddress(Long addressId){
        return orderRepository.findByAddress(addressId);
    }

    List<Order> findByIsDelivered(boolean isDelivered){
        return orderRepository.findByIsDelivered(isDelivered);
    }

    List<Order> findByShipper(Long shipperId){
        return orderRepository.findByShipper(shipperId);
    }

}
