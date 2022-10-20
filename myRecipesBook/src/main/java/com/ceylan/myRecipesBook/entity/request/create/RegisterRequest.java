package com.ceylan.myRecipesBook.entity.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Boş olamaz")
    @NotNull
    @Email
    private String email;

    @NotBlank(message = "Boş olamaz")
    @NotNull
    @Size(min = 6)
    private String password;
}

