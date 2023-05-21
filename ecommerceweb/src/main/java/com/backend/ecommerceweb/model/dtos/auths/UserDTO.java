package com.backend.ecommerceweb.model.dtos.auths;

import com.backend.ecommerceweb.entities.Address;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String name;
    private String gender;
    private Date birthday;
    private String phone;
    private String email;
    private String urlAvt;
    private int point;
    private List<Address> addresses;
    private Date createAt;
    private boolean active;
}
