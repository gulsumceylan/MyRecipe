package com.ceylan.myRecipesBook.entity.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @javax.validation.constraints.NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
