package com.example.court_reserve.controller;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.controller.response.BookingResponse;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.mapper.BookingMapper;
import com.example.court_reserve.service.BookingService;
import com.example.court_reserve.service.CourtService;
import com.example.court_reserve.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Builder
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/court_reserve/bookings")
@RequiredArgsConstructor
@Tag(name = "Booking",description = "Recurso responsável pelos agendamentos.")
public class BookingController {

    private final BookingService bookingService;
    private final CourtService courtService;
    private final UserService userService;
    @Operation(summary = "Buscar horários",description = "busca os horários agendados.")
    @ApiResponse(responseCode = "201",description ="Lista de agendamentos revelada com sucesso." )
    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        List<BookingResponse> bookings=bookingService.findAll()
                .stream()
                .map(booking -> BookingMapper.toBookingResponse(booking))
                .toList();
        return ResponseEntity.ok(bookings);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getByBookingId(@PathVariable Long id){
        return bookingService.findById(id)
                .map(booking -> ResponseEntity.ok(BookingMapper.toBookingResponse(booking)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<BookingResponse> saveBooking(@RequestBody BookingRequest request){
        Court court=courtService.findById(request.courtId())
                .orElseThrow(()->new RuntimeException("Quadra não encontrada"));

        User user=userService.findById(request.userId())
                .orElseThrow(()->new RuntimeException("Usuário não encontrado"));
        Booking booking=BookingMapper.toBooking(request,court,user);
        Booking saved=bookingService.save(booking);
        return ResponseEntity.ok(BookingMapper.toBookingResponse(saved));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBooking(
            @PathVariable Long id,
            @RequestBody BookingRequest request) {

        Booking updatedBooking = bookingService.update(id, request);
        return ResponseEntity.ok(BookingMapper.toBookingResponse(updatedBooking));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByBookingId(@PathVariable Long id){
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
