package com.backend.ecommerceweb.model.dtos.auths;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ValidateOtpInpoutDTO {
    @NotBlank(message = "Email là bắt buộc")
    private String email;

    @NotBlank(message = "OTP là bắt buộc")
    private int otp;

    @NotBlank(message = "Mật khẩu là bắt buộc")
    private String password;
}
