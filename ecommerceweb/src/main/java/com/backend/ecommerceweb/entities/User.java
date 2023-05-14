package com.backend.ecommerceweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Data
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity{

    private String user_name;
    private String name;
    private String gender;
    private String birthday;
    private String phone;
    private String email;
    private String user_url_avt;
    private Long point;
    private String created_at;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private UserLogin userLogin;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "to_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Where(clause = "type = 'USER'")
    private List<Address> addresses;
}
