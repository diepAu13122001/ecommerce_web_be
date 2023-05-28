package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    List<PaymentMethod> findByName (String name);
    List<PaymentMethod> findByNameContaining(String name);
    List<PaymentMethod> findByImgUrlContaining(String imgUrl);
    List<PaymentMethod> findByMinTransfer(Double minTransfer);
    List<PaymentMethod> findByMinTransferLessThanEqual(Double minTransfer);
    List<PaymentMethod> findByMinTransferGreaterThanEqual(Double minTransfer);
    List<PaymentMethod> findByMaxTransfer(Double maxTransfer);
    List<PaymentMethod> findByMaxTransferLessThanEqual(Double maxTransfer);
    List<PaymentMethod> findByMaxTransferGreaterThanEqual(Double maxTransfer);

}
