package com.example.hotel_new.Controller;


import com.example.hotel_new.Entity.Booking;
import com.example.hotel_new.ModelDTO.BookingResponseDTO;
import com.example.hotel_new.Repository.BookingRepository;
import com.example.hotel_new.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{roomId}")
    public ResponseEntity<String> bookRoom(@PathVariable Long roomId, @RequestBody Booking booking) {
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
