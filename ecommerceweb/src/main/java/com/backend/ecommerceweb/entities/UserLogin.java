package com.backend.ecommerceweb.entities;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "user_login")
@Getter
@Setter
public class UserLogin {

    @Id
    @Column(name = "user_id")
    private Long userId;

    private Boolean active;

    private String password;


}
