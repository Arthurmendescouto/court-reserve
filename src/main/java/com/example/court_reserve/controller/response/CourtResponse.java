package com.example.court_reserve.controller.response;

import com.example.court_reserve.entity.SportType;
import lombok.Builder;

@Builder
public record CourtResponse(Long id, SportType sportType, Double pricePerHour, Boolean isAvailable) {
}
