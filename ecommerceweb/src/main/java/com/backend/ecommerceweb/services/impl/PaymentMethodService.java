package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.services.ABaseService;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class PaymentMethodService extends ABaseService{
    List<PaymentMethod> findByName (String name){
        return paymentMethodRepository.findByName(name);
    }
    List<PaymentMethod> findByNameContaining(String name){
        return paymentMethodRepository.findByNameContaining(name);
    }
    List<PaymentMethod> findByImgUrlContaining(String imgUrl){
        return paymentMethodRepository.findByImgUrlContaining(imgUrl);
    }
    List<PaymentMethod> findByMinTransfer(Double minTransfer){
        return paymentMethodRepository.findByMinTransfer(minTransfer);
    }
    List<PaymentMethod> findByMinTransferLessThanEqual(Double minTransfer) {
        return paymentMethodRepository.findByMinTransferLessThanEqual(minTransfer);
    }
    List<PaymentMethod> findByMinTransferGreaterThanEqual(Double minTransfer){
        return paymentMethodRepository.findByMinTransferGreaterThanEqual(minTransfer);
    }
    List<PaymentMethod> findByMaxTransfer(Double maxTransfer){
        return paymentMethodRepository.findByMaxTransfer(maxTransfer);
    }
    List<PaymentMethod> findByMaxTransferLessThanEqual(Double maxTransfer){
        return paymentMethodRepository.findByMaxTransferLessThanEqual(maxTransfer);
    }
    List<PaymentMethod> findByMaxTransferGreaterThanEqual(Double maxTransfer){
        return paymentMethodRepository.findByMaxTransferGreaterThanEqual(maxTransfer);
    }


}
