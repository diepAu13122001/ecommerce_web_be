package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import java.util.Date;

import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otp")
public class OTP {
    @Id
    @Column(name = "user_id")
    private Long userId;
    private long otp_number;
    private Date created_at;

}

