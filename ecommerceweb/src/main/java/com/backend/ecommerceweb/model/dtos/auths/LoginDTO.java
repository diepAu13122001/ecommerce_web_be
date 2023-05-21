package com.backend.ecommerceweb.model.dtos.auths;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotBlank(message = "Email là bắt buộc")
    @Email(message = "Email không hợp lệ", regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
    private String email;

    @NotBlank(message = "Mật khẩu là bắt buộc")
    private String password;
}
