package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.UserCart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserCartService {
    public List<UserCart> findByProductAmount(int amount);

    List<UserCart> findByGiftId(Long id);

    UserCart findByUserId(Long userId);

    List<UserCart> findAll();

    UserCart findById(Long id);

    UserCart createUserCart(UserCart userCart);

    void delete(Long id);
}
