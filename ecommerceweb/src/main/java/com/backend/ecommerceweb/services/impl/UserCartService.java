package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.User;
import com.backend.ecommerceweb.entities.UserCart;
import com.backend.ecommerceweb.entities.Ward;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
