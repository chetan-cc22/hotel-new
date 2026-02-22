package com.example.hotel_new.Controller;


import com.example.hotel_new.Entity.Booking;
import com.example.hotel_new.ModelDTO.BookingRequestDTO;
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
    //abhi update kiya yeh
    @PostMapping
    public ResponseEntity<String> bookRoom(
            @RequestBody BookingRequestDTO request) {

        Booking booking = new Booking();
        booking.setCheckIn(request.getCheckIn());
        booking.setCheckOut(request.getCheckOut());

        boolean success = bookingService.createBooking(
                request.getRoomId(),
                request.getUserId(),
                booking
        );

        if (success) {
            return ResponseEntity.ok("Booking Confirmed");
        } else {
            return ResponseEntity.badRequest().body("Room not available");
        }
    }



    @GetMapping("/history/{userId}")
    public List<BookingResponseDTO> getHistory(@PathVariable Long userId) {
        return bookingService.getHistory(userId);
    }
}
