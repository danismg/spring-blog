package com.fastcampus.blog.request.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class AuthRequest {

    @NotBlank
    @Size(min = 2, max = 20, message = "Name tidak boleh kurang dari 2")
    private String name;

    @NotBlank
    @Size(min = 2, max = 20, message = "Password tidak boleh kurang dari 2")
    private String password;
}
