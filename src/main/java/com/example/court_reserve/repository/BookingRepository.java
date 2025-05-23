package com.example.court_reserve.repository;

import com.example.court_reserve.entity.Booking;
import com.example.court_reserve.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
