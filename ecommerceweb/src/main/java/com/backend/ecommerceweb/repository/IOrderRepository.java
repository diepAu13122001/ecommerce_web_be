package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
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

    List<Order> findByPaymentMethod(PaymentMethod method);

    List<Order> findByCreatedUser(Long userId);

    List<Order> findByUpdatedUser(Long userId);

    List<Order> findByAddress(Long addressId);

    List<Order> findByIsDelivered(boolean isDelivered);

    List<Order> findByShipper(Long shipperId);


}
