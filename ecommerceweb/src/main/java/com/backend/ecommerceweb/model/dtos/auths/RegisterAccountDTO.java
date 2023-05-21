package com.backend.ecommerceweb.model.dtos.auths;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class RegisterAccountDTO {

    @NotBlank(message = "Email là bắt buộc")
    @Email(message = "Email không hợp lệ",regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
    private String email;

    @NotBlank(message = "Tên là bắt buộc")
    private String name;

    @NotBlank(message = "Mật khẩu là bắt buộc")
    private String password;

}
