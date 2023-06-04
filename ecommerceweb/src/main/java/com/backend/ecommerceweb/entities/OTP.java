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
@Getter
@Setter
@Table(name = "`otp`")
public class OTP {

    @Id
    @Column(name = "user_id")
    private Long userId;
    private long otp_number;
    private Date created_at;

}
