package com.example.court_reserve.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "LoginRequest", description = "Objeto de requisição para login de usuário.")
public record LoginRequest(
        @Schema(description = "E-mail do usuário.", example = "joao@email.com")
        @NotBlank(message = "O e-mail não pode estar em branco.")
        @Email(message = "O formato do e-mail é inválido.")
        String email,

        @Schema(description = "Senha do usuário.", example = "senha123")
        @NotBlank(message = "A senha não pode estar em branco.")
        String password
) {
}