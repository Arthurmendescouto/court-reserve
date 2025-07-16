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

import com.example.court_reserve.controller.request.CourtRequest;
import com.example.court_reserve.controller.response.CourtResponse;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.mapper.CourtMapper;
import com.example.court_reserve.service.CourtService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
@SecurityRequirement(name = "bearerAuth")
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
    @PatchMapping("/{id}")
    public ResponseEntity<CourtResponse> patchCourt(@PathVariable Long id, @RequestBody CourtRequest request) {
        Court updatedCourt = courtService.updateCourt(id, request);
        return ResponseEntity.ok(CourtMapper.toCourtResponse(updatedCourt));
    }

}
