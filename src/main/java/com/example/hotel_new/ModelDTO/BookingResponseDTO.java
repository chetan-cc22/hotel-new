package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {
    private Long bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDateTime bookingTime;

    private Long roomId;
    private String roomType;
    private Double roomPrice;

}
