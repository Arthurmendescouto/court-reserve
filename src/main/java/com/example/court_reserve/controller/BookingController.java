package com.example.court_reserve.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

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
    @Operation(summary = "Listar agendamentos", description = "Retorna todos os agendamentos cadastrados.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de agendamentos revelada com sucesso."),
        @ApiResponse(responseCode = "401", description = "Não autorizado"),
        @ApiResponse(responseCode = "403", description = "Acesso proibido.")
    })
    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        List<BookingResponse> bookings=bookingService.findAll()
                .stream()
                .map(booking -> BookingMapper.toBookingResponse(booking))
                .toList();
        return ResponseEntity.ok(bookings);
    }
    @Operation(summary = "Buscar agendamento por ID", description = "Retorna um agendamento específico pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Agendamento encontrado."),
        @ApiResponse(responseCode = "404", description = "Agendamento não encontrado."),
        @ApiResponse(responseCode = "401", description = "Não autorizado"),
        @ApiResponse(responseCode = "403", description = "Acesso proibido.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getByBookingId(@PathVariable Long id){
        return bookingService.findById(id)
                .map(booking -> ResponseEntity.ok(BookingMapper.toBookingResponse(booking)))
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Criar agendamento", description = "Cria um novo agendamento.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Agendamento criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos."),
        @ApiResponse(responseCode = "404", description = "Usuário ou quadra não encontrado."),
        @ApiResponse(responseCode = "401", description = "Não autorizado"),
        @ApiResponse(responseCode = "403", description = "Acesso proibido.")
    })
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
    @Operation(summary = "Atualizar agendamento", description = "Atualiza um agendamento existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Agendamento atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Agendamento não encontrado."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos."),
        @ApiResponse(responseCode = "401", description = "Não autorizado"),
        @ApiResponse(responseCode = "403", description = "Acesso proibido.")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBooking(
            @PathVariable Long id,
            @RequestBody BookingRequest request) {

        Booking updatedBooking = bookingService.update(id, request);
        return ResponseEntity.ok(BookingMapper.toBookingResponse(updatedBooking));
    }
    @Operation(summary = "Deletar agendamento", description = "Remove um agendamento pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Agendamento deletado com sucesso."),
        @ApiResponse(responseCode = "403", description = "Acesso proibido.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByBookingId(@PathVariable Long id){
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
