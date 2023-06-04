package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOtpRepository extends JpaRepository<OTP, Long> {
    OTP findOtpByUserId(Long userId);
}