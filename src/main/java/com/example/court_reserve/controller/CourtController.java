package com.example.court_reserve.controller;

import com.example.court_reserve.controller.request.BookingRequest;
import com.example.court_reserve.controller.request.CourtRequest;
import com.example.court_reserve.controller.response.BookingResponse;
import com.example.court_reserve.controller.response.CourtResponse;
import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.mapper.BookingMapper;
import com.example.court_reserve.mapper.CourtMapper;
import com.example.court_reserve.service.BookingService;
import com.example.court_reserve.service.CourtService;
import com.example.court_reserve.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/court_reserve/courts")
@RequiredArgsConstructor
public class CourtController {
    private final CourtService courtService;

    @GetMapping
    public ResponseEntity<List<CourtResponse>> getAllCourts(){
    List<CourtResponse> courts=courtService.findAll()
            .stream()
            .map(court -> CourtMapper.toCourtResponse(court))
            .toList();
    return ResponseEntity.ok(courts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourtResponse> getCourtsById(@PathVariable Long id){
        return courtService.findById(id)
                .map(court -> ResponseEntity.ok(CourtMapper.toCourtResponse(court)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CourtResponse> saveCourt(@RequestBody CourtRequest request){
        Court newCourt=CourtMapper.toCourt(request);
        Court savedCourt=courtService.save(newCourt);
        return ResponseEntity.status(HttpStatus.CREATED).body(CourtMapper.toCourtResponse(savedCourt));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCourtId(@PathVariable Long id){
        courtService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
