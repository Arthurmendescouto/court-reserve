package com.example.court_reserve.controller.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "BookingRequest", description = "Objeto de requisição para criar ou atualizar um agendamento.")
public record BookingRequest(
        @Schema(description = "ID do usuário que está realizando o agendamento.", example = "1")
        Long userId,
        @Schema(description = "ID da quadra a ser reservada.", example = "2")
        Long courtId,
        @Schema(description = "Data e hora de início do agendamento.", example = "2024-06-01T10:00:00")
        LocalDateTime startDateTime,
        @Schema(description = "Data e hora de término do agendamento.", example = "2024-06-01T11:00:00")
        LocalDateTime endDateTime) {
}
