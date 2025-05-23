package com.example.court_reserve.mapper;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.controller.request.CourtRequest;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.SportType;
import com.example.court_reserve.entity.User;
import org.apache.catalina.mapper.Mapper;

public class CourtMapper {
    public static Court toCourt(CourtRequest courtRequest){
        return Court.
                builder()
                .sportType(courtRequest.sportType())
                .courtValue(courtRequest.pricePerHour())
                .build();

    }
}
