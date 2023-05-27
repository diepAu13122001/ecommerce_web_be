package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.OrderDetail;
import com.backend.ecommerceweb.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByProduct(Long productId);
    List<OrderDetail> findByQuantity(int quantity);
    List<OrderDetail> findByQuantityBetween(int min, int max);
    List<OrderDetail> findByQuantityLessThanEqual(int quantity);
    List<OrderDetail> findByQuantityGreaterThanEqual(int quantity);
    List<OrderDetail> findByIntoMoney(Long intoMoney);
    List<OrderDetail> findByIntoMoneyBetween(Long min, Long max);
    List<OrderDetail> findByIntoMoneyLessThanEqual(Long intoMoney);
    List<OrderDetail> findByIntoMoneyGreaterThanEqual(Long intoMoney);
    List<OrderDetail> findByOrder(Long orderId);
}
