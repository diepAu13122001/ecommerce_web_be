package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "otp")
public class OTP extends  BaseEntity{

    private int otp_number;
    private Date created_at;

}
