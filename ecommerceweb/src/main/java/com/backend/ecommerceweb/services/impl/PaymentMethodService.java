package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Order;
import com.backend.ecommerceweb.entities.PaymentMethod;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IPaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService extends ABaseService implements IPaymentMethodService {
    public List<PaymentMethod> findByName(String name) {
        return paymentMethodRepository.findByName(name);
    }

    public List<PaymentMethod> findByNameContaining(String name) {
        return paymentMethodRepository.findByNameContaining(name);
    }

    public List<PaymentMethod> findByImgUrlContaining(String imgUrl) {
        return paymentMethodRepository.findByImgUrlContaining(imgUrl);
    }

    public List<PaymentMethod> findByMinTransfer(Double minTransfer) {
        return paymentMethodRepository.findByMinTransfer(minTransfer);
    }

    public List<PaymentMethod> findByMinTransferLessThanEqual(Double minTransfer) {
        return paymentMethodRepository.findByMinTransferLessThanEqual(minTransfer);
    }

    public List<PaymentMethod> findByMinTransferGreaterThanEqual(Double minTransfer) {
        return paymentMethodRepository.findByMinTransferGreaterThanEqual(minTransfer);
    }

    public List<PaymentMethod> findByMaxTransfer(Double maxTransfer) {
        return paymentMethodRepository.findByMaxTransfer(maxTransfer);
    }

    public List<PaymentMethod> findByMaxTransferLessThanEqual(Double maxTransfer) {
        return paymentMethodRepository.findByMaxTransferLessThanEqual(maxTransfer);
    }

    public List<PaymentMethod> findByMaxTransferGreaterThanEqual(Double maxTransfer) {
        return paymentMethodRepository.findByMaxTransferGreaterThanEqual(maxTransfer);
    }

    @Override
    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod findById(Long id) {
        Optional<PaymentMethod> p = paymentMethodRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void delete(Long id) {
        paymentMethodRepository.deleteById(id);
    }


}
