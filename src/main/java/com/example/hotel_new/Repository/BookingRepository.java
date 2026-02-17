package com.example.hotel_new.Repository;

import com.example.hotel_new.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
