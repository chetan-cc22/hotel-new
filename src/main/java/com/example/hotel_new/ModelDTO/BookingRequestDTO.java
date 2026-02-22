package com.example.hotel_new.ModelDTO;

import lombok.Data;

import java.time.LocalDate;


//room booking ke liye yeh banaya hai
@Data
public class BookingRequestDTO {
    private Long roomId;
    private Long userId;
    private LocalDate checkIn;
    private LocalDate checkOut;

}

