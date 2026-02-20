package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {

    private Long id;  // changed from bookingId
    private LocalDate checkIn;
    private LocalDate checkOut;

    // Must match frontend template exactly
    private String type;
    private Double price;
    private LocalDateTime lastBooked;
}