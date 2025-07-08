package com.example.court_reserve.controller.request;

import com.example.court_reserve.entity.Court;

import java.time.LocalDateTime;

public record BookingRequest(Long userId, Long courtId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
}
