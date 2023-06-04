package com.backend.ecommerceweb.model.dtos.auths;

import com.backend.ecommerceweb.enums.Enums;
import com.backend.ecommerceweb.model.dtos.address.AddressDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserInputDTO {

    @NotNull(message = "ID không được bỏ trống")
    private Long id;

    private String name;

    private Enums.Gender gender;

    private String phone;

    private Long birthday;

    private String introduce;

    private AddressDTO address;

}
