package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long roomId;
    private Long userId;
    private LocalDate checkIn;
    private LocalDate checkOut;

}

