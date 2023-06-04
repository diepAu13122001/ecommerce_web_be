package com.backend.ecommerceweb.model.dtos.auths;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class UpdateAvatarInputDTO {

    @NotNull(message = "ID không được bỏ trống")
    private Long id;

    @NotBlank(message = "URL không được bỏ trống")
    private String url;
}
