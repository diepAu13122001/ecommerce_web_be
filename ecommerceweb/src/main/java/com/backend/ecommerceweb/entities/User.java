package com.backend.ecommerceweb.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "`user`",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        )
)
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    private String name;
    private String gender;
    private Date birthday;
    private String phone;
    private String email;
    @Column(name = "user_url_avt")
    private String user_url_avt;
    private Long point;
    private Date created_at;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private UserLogin userLogin;

//    @OneToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @JoinColumn(name = "to_id", referencedColumnName = "id", updatable = false, insertable = false)
//    @Where(clause = "type = 'USER'")
//    private List<Address> addresses;
}
