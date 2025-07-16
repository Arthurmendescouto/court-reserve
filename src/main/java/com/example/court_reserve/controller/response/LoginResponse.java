package com.example.court_reserve.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "LoginResponse", description = "Resposta do login contendo o token JWT.")
public record LoginResponse(
        @Schema(description = "Token JWT de autenticação.", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String token) {
}
