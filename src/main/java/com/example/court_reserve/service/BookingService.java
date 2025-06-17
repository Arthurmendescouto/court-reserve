package com.example.court_reserve.service;

import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository repository;

    public List<Booking> findAll(){
        return repository.findAll();
    }

    public Optional<Booking> findById(Long id){
        return repository.findById(id);
    }

    public Booking save(Booking booking){
        return repository.save(booking);
    }

    public void  delete(Long id){
         repository.deleteById(id);
    }
}
