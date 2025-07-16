package com.example.court_reserve.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserRequest", description = "Objeto de requisição para criar ou atualizar um usuário.")
public record UserRequest(
        @Schema(description = "Nome do usuário.", example = "João Silva")
        String name,
        @Schema(description = "E-mail do usuário.", example = "joao@email.com")
        String email,
        @Schema(description = "Senha do usuário.", example = "senha123")
        String password) {
}
