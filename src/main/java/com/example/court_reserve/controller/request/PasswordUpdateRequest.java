package com.example.court_reserve.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(name = "PasswordUpdateRequest", description = "Objeto de requisição para atualizar a senha do usuário.")
public record PasswordUpdateRequest(
        @Schema(description = "A nova senha do usuário.", example = "novaSenhaForte123")
        @NotBlank(message = "A senha não pode estar em branco.")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
        String password
) {
}