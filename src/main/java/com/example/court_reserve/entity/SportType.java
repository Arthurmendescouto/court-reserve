package com.example.court_reserve.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enumeração dos tipos de esportes disponíveis para quadras.")
public enum SportType {
    @Schema(description = "Futebol")
    FOOTBALL,
    @Schema(description = "Basquete")
    BASKETBALL,
    @Schema(description = "Vôlei")
    VOLLEYBALL,
    @Schema(description = "Tênis")
    TENNIS;
}
