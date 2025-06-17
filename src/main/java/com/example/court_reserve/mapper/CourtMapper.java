package com.example.court_reserve.mapper;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.controller.request.CourtRequest;
import com.example.court_reserve.controller.response.CourtResponse;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.SportType;
import com.example.court_reserve.entity.User;
import lombok.experimental.UtilityClass;
import org.apache.catalina.mapper.Mapper;

import java.awt.print.Book;

@UtilityClass
public class CourtMapper {
    public static Court toCourt(CourtRequest request){
        return Court.builder()
                .sportType(request.sportType())
                .pricePerHour(request.pricePerHour())
                .isAvailable(request.isAvailable())
                .build();
    }
    public static CourtResponse toCourtResponse(Court court){
        return CourtResponse.builder()
                .id(court.getId())
                .sportType(court.getSportType())
                .pricePerHour(court.getPricePerHour())
                .isAvailable(court.isAvailable())
                .build();

    }
}
        //Long id, SportType sportType, Double pricePerHour, Boolean isAvailable