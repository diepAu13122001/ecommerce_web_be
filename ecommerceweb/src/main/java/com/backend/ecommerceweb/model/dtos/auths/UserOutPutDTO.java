package com.backend.ecommerceweb.model.dtos.auths;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UserOutPutDTO {

    private Long id;

    private String name;

    private String email;

    private List<Address> addresses;

    private String gender;

    private String phone;

    private Date birthday;

    private String username;

    private boolean active;

    private String urlAvt;

    private String introduce;

    private Set<Role> roles;

    private Date createdAt;
}
