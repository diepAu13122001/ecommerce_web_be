package com.backend.ecommerceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OTP {

    @Id
    @GeneratedValue
    private Long id;
    private int otp_number;
    private String created_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOtp_number() {
        return otp_number;
    }

    public void setOtp_number(int otp_number) {
        this.otp_number = otp_number;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
