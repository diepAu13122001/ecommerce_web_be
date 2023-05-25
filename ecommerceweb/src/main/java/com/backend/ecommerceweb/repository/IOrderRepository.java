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

}
