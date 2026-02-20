package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {
    private Long bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    //frotnend ke variable se matching
    private String type;
    private Double price;
    private LocalDateTime lastBooked;

//    private LocalDateTime bookingTime;

//    private Long roomId;
//    private String roomType;
//    private Double roomPrice;

}



