package com.example.court_reserve.mapper;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingMapper {
    public static Booking toBooking(BookingRequest bookingRequest, Court court, User user){
        return Booking.
                builder()
                .startDateTime(bookingRequest.startDateTime())
                .endDateTime(bookingRequest.endDateTime())
                .court(court)
                .user(user)
                .build();

    }
}
