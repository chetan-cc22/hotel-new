package com.example.hotel_new.Service;

import com.example.hotel_new.Entity.User;
import com.example.hotel_new.ModelDTO.BookingResponseDTO;
import com.example.hotel_new.Entity.Booking;
import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.Repository.BookingRepository;
import com.example.hotel_new.Repository.RoomRepository;
import com.example.hotel_new.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    //currently change kiya
    private BookingResponseDTO mapToDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();

        dto.setId(booking.getId());   // changed
        dto.setCheckIn(booking.getCheckIn());
        dto.setCheckOut(booking.getCheckOut());
        dto.setLastBooked(booking.getBookingTime());

        dto.setType(booking.getRoom().getType());
        dto.setPrice(booking.getRoom().getPrice());

        return dto;
    }


    @Transactional
    public boolean createBooking(Long roomId, Long userId, Booking bookingDetails) {

        Room room = roomRepository.findById(roomId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (room != null && user != null && room.getCount() > 0) {

            room.setCount(room.getCount() - 1);
            roomRepository.save(room);

            bookingDetails.setRoom(room);
            bookingDetails.setUser(user);
            bookingDetails.setBookingTime(LocalDateTime.now());

            bookingRepository.save(bookingDetails);

            return true;
        }

        return false;
    }


    public List<BookingResponseDTO> getHistory(Long userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


}
