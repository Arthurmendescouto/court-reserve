package com.example.court_reserve.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(name = "UserRequest", description = "Objeto de requisição para criar ou atualizar um usuário.")
public record UserRequest(
        @Schema(description = "Nome do usuário.", example = "João Silva")
        @NotBlank(message = "O nome não pode estar em branco.")
        String name,

        @Schema(description = "E-mail do usuário.", example = "joao@email.com")
        @NotBlank(message = "O e-mail não pode estar em branco.")
        @Email(message = "O formato do e-mail é invalido.")
        String email,

        @Schema(description = "Senha do usuário.", example = "senha123")
        @NotBlank(message = "A senha não pode estar em branco.")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
        String password) {
}
