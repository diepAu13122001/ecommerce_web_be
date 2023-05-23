package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findByEmail(String email);
    Optional<User> findById(Long userId);
    List<User> findUsersByIdIn(List<Long> ids);
}
