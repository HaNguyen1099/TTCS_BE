package com.quanchun.backendexamsystem.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
