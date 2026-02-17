package com.example.hotel_new.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDateTime bookingTime;

    // We link the booking to a Room to fetch type/price later
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
