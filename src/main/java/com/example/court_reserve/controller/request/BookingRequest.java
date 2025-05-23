package com.example.court_reserve.controller.request;

import com.example.court_reserve.entity.Court;

import java.time.LocalDateTime;

public record BookingRequest( Long bookingId, LocalDateTime startDateTime,LocalDateTime endDateTime) {
}
