package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import java.util.Date;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "otp")
public class OTP extends  BaseEntity{

    private int otp_number;
    private Date created_at;

}
