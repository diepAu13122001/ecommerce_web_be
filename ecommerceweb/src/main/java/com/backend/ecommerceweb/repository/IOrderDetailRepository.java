package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.OrderDetail;
import com.backend.ecommerceweb.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
//    List<OrderDetail> findByUserId (String userId);
//    List<OrderDetail> findByAddressId (String addressId);
//    List<OrderDetail> findByOrderDate (Date orderDate);
//    List<OrderDetail> findByDeliveryDate (Date deliveryDate);
//    List<OrderDetail> findByPaymentMethod (PaymentMethod paymentMethod);
//    List<OrderDetail> findByDeliveryStatus (String isDelivered);
}
