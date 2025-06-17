package com.example.court_reserve.service;

import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.repository.BookingRepository;
import com.example.court_reserve.repository.CourtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourtService {
    private final CourtRepository repository;

    public List<Court> findAll(){
        return repository.findAll();
    }

    public Optional<Court> findById(Long id){
        return repository.findById(id);
    }

    public Court save(Court court){
        return repository.save(court);
    }

    public void  delete(Long id){
        repository.deleteById(id);
    }
}
