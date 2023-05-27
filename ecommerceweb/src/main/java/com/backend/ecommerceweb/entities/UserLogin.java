package com.backend.ecommerceweb.entities;
import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_login")
public class UserLogin {

    @Id
    @Column(name = "user_id")
    private Long userId;

    private Boolean active;

    private String password;


}
