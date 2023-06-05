package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {
    List<PaymentMethod> findByName(String name);

    List<PaymentMethod> findByNameContaining(String name);

    List<PaymentMethod> findByImgUrlContaining(String imgUrl);

    List<PaymentMethod> findByMinTransfer(Double minTransfer);

    List<PaymentMethod> findByMinTransferLessThanEqual(Double minTransfer);

    List<PaymentMethod> findByMinTransferGreaterThanEqual(Double minTransfer);

    List<PaymentMethod> findByMaxTransfer(Double maxTransfer);

    List<PaymentMethod> findByMaxTransferLessThanEqual(Double maxTransfer);

    List<PaymentMethod> findByMaxTransferGreaterThanEqual(Double maxTransfer);

    List<PaymentMethod> findAll();

    PaymentMethod findById(Long id);

    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);

    void delete(Long id);


}
