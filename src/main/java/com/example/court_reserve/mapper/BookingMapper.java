package com.example.court_reserve.mapper;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.controller.response.BookingResponse;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingMapper {
    public static Booking toBooking(BookingRequest bookingRequest, Court court, User user){
        return Booking
                .builder()
                .startDateTime(bookingRequest.startDateTime())
                .endDateTime(bookingRequest.endDateTime())
                .court(court)
                .user(user)
                .build();
    }
    public static BookingResponse toBookingResponse(Booking booking){
        return BookingResponse
                .builder()
                .id(booking.getId())
                .startDateTime(booking.getStartDateTime())
                .endDateTime(booking.getEndDateTime())
                .build();
    }
}
