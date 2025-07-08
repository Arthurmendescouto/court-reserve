package com.example.court_reserve.controller.response;

import com.example.court_reserve.entity.SportType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingResponse(
        Long id, LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        UserInfo user,
        CourtInfo court
                              ) {
    public record UserInfo(
            Long id,
            String email){}
    public record CourtInfo(
            Long id,
            SportType sportType,
            Double pricePerHour){}
}
