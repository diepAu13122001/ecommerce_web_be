package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IOrderService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class OrderService extends ABaseService implements IOrderService {
    public List<Order> findByOrderedDate(Date orderedDate) {
        return orderRepository.findByOrderedDate(orderedDate);
    }

    public List<Order> findByOrderedDateGreaterThanEqual(Date orderedDate) {
        return orderRepository.findByOrderedDateGreaterThanEqual(orderedDate);
    }

    public List<Order> findByOrderedDateLessThanEqual(Date orderedDate) {
        return orderRepository.findByOrderedDateLessThanEqual(orderedDate);
    }

    public List<Order> findByOrderedDateBetween(Date started, Date ended) {
        return orderRepository.findByOrderedDateBetween(started, ended);
    }

    public List<Order> findByDeliveredDate(Date deliveredDate) {
        return orderRepository.findByDeliveredDate(deliveredDate);
    }

    public List<Order> findByDeliveredDateGreaterThanEqual(Date deliveredDate) {
        return orderRepository.findByDeliveredDateGreaterThanEqual(deliveredDate);
    }

    public List<Order> findByDeliveredDateLessThanEqual(Date deliveredDate) {
        return orderRepository.findByDeliveredDateLessThanEqual(deliveredDate);
    }

    public List<Order> findByDeliveredDateBetween(Date started, Date ended) {
        return orderRepository.findByDeliveredDateBetween(started, ended);
    }

    public List<Order> findByUpdatedDate(Date updatedDate) {
        return orderRepository.findByUpdatedDate(updatedDate);
    }

    public List<Order> findByUpdatedDateGreaterThanEqual(Date updatedDate) {
        return orderRepository.findByUpdatedDateGreaterThanEqual(updatedDate);
    }

    public List<Order> findByUpdatedDateLessThanEqual(Date updatedDate) {
        return orderRepository.findByUpdatedDateLessThanEqual(updatedDate);
    }

    public List<Order> findByUpdatedDateBetween(Date started, Date ended) {
        return orderRepository.findByUpdatedDateBetween(started, ended);
    }

    public List<Order> findByOrderStatus(String status) {
        return orderRepository.findByOrderStatus(status);
    }

    public List<Order> findByPaymentMethod(Long methodId) {
        return orderRepository.findByPaymentMethod(methodId);
    }

    @Override
    public List<Order> findByCreatedUserId(Long userId) {
        return orderRepository.findByCreatedUserId(userId);
    }

    @Override
    public List<Order> findByUpdatedUserId(Long userId) {
        return orderRepository.findByUpdatedUserId(userId);
    }

    @Override
    public List<Order> findByAddressId(Long addressId) {
        return orderRepository.findByAddressId(addressId);
    }

    public List<Order> findByCreatedUser(Long userId) {
        return orderRepository.findByCreatedUserId(userId);
    }

    public List<Order> findByUpdatedUser(Long userId) {
        return orderRepository.findByUpdatedUserId(userId);
    }

    public List<Order> findByAddress(Long addressId) {
        return orderRepository.findByAddressId(addressId);
    }

    public List<Order> findByIsDelivered(boolean isDelivered) {
        return orderRepository.findByIsDelivered(isDelivered);
    }

    public List<Order> findByShipper(Long shipperId) {
        return orderRepository.findByShipper(shipperId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> o = orderRepository.findById(id);
        return o.isPresent() == false ? null : o.get();
    }

    @Override
    public List<Order> findAllByOrderByOrderedDateDesc() {
        return orderRepository.findAllByOrderByOrderedDateDesc();
    }

    @Override
    public List<Order> findAllByOrderByDeliveredDateDesc() {
        return orderRepository.findAllByOrderByDeliveredDateDesc();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

}
