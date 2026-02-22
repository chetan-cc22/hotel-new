package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {


    //yeh history fetch krne me kaam ata hai
    private Long id;  // changed from bookingId
    private LocalDate checkIn;
    private LocalDate checkOut;

    // manav ka frontend logic
    private String type;
    private Double price;
    private LocalDateTime lastBooked;
}