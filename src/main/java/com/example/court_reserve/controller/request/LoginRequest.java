package com.example.court_reserve.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "LoginRequest", description = "Objeto de requisição para login de usuário.")
public record LoginRequest(
        @Schema(description = "E-mail do usuário.", example = "joao@email.com")
        String email,
        @Schema(description = "Senha do usuário.", example = "senha123")
        String password) {
}
