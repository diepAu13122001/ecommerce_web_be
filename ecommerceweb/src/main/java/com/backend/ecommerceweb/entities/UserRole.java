package com.backend.ecommerceweb.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "`user_role`")
@Data
@IdClass(UserRole.class)
public class UserRole implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "role_id")
    private String roleId;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="role_id")
//    private Role role;

}
