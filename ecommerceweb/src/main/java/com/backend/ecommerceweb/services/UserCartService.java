package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.UserCart;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserCartService extends ABaseService{
    public List<UserCart> findByProductAmount(int amount) {
        return userCartRepository.findByProductAmount(amount);
    }
    List<UserCart> findByGiftId(Long id){
        return userCartRepository.findByGiftId(id);
    }
    UserCart findByUser(Long userId) {
        return userCartRepository.findByUser(userId);
    }
}
