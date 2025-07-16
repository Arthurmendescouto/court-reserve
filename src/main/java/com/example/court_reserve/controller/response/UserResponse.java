package com.example.court_reserve.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(name = "UserResponse", description = "Resposta com os dados de um usuário.")
@Builder
public record UserResponse(
        @Schema(description = "ID do usuário.", example = "1")
        Long id,
        @Schema(description = "Nome do usuário.", example = "João Silva")
        String name,
        @Schema(description = "E-mail do usuário.", example = "joao@email.com")
        String email) {
}
