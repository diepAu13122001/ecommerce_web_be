package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    List<Order> findByOrderedDate(Date orderedDate);

    List<Order> findByOrderedDateGreaterThanEqual(Date orderedDate);

    List<Order> findByOrderedDateLessThanEqual(Date orderedDate);

    List<Order> findByOrderedDateBetween(Date started, Date ended);

    List<Order> findByDeliveredDate(Date deliveredDate);

    List<Order> findByDeliveredDateGreaterThanEqual(Date deliveredDate);

    List<Order> findByDeliveredDateLessThanEqual(Date deliveredDate);

    List<Order> findByDeliveredDateBetween(Date started, Date ended);

    List<Order> findByUpdatedDate(Date updatedDate);

    List<Order> findByUpdatedDateGreaterThanEqual(Date updatedDate);

    List<Order> findByUpdatedDateLessThanEqual(Date updatedDate);

    List<Order> findByUpdatedDateBetween(Date started, Date ended);

    List<Order> findByOrderStatus(String status);

    List<Order> findByPaymentMethod(Long methodId);

    List<Order> findByCreatedUserId(Long userId);

    List<Order> findByUpdatedUserId(Long userId);

    List<Order> findByAddressId(Long addressId);

    List<Order> findByIsDelivered(boolean isDelivered);

    List<Order> findByShipper(Long shipperId);

    List<Order> findAll();

    Order findById(Long id);

    List<Order> findAllByOrderByOrderedDateDesc();

    List<Order> findAllByOrderByDeliveredDateDesc();

    Order createOrder(Order order);

    void deleteById(Long id);

}
