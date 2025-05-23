package com.example.court_reserve.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingResponse(Long id, LocalDateTime startDateTime, LocalDateTime endDateTime) {
}
