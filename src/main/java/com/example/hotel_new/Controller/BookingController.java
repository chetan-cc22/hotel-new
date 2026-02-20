package com.example.hotel_new.Controller;


import com.example.hotel_new.Entity.Booking;
import com.example.hotel_new.ModelDTO.BookingResponseDTO;
import com.example.hotel_new.Repository.BookingRepository;
import com.example.hotel_new.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookRoom(
            @RequestBody Map<String, Object> data) {

        Long roomId = Long.valueOf(data.get("roomId").toString());

        Booking booking = new Booking();
        booking.setCheckIn(LocalDate.parse(data.get("checkIn").toString()));
        booking.setCheckOut(LocalDate.parse(data.get("checkOut").toString()));

        boolean success = bookingService.createBooking(roomId, booking);

        if (success) {
            return ResponseEntity.ok("Booking Confirmed");
        } else {
            return ResponseEntity.badRequest().body("Room not available");
        }
    }

    @GetMapping("/history")
    public List<BookingResponseDTO> getHistory() {
        return bookingService.getHistory();
    }
}
