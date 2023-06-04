package com.backend.ecommerceweb.model.dtos.auths;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PasswordInputDTO {

    @NotBlank(message = "Mật khẩu cũ không được bỏ trống")
    private String oldPassword;

    @NotBlank(message = "Mật khẩu mới không được bỏ trống")
    private String newPassword;
}
