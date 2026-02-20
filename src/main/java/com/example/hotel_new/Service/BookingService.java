package com.example.hotel_new.Service;

import com.example.hotel_new.ModelDTO.BookingResponseDTO;
import com.example.hotel_new.Entity.Booking;
import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.Repository.BookingRepository;
import com.example.hotel_new.Repository.RoomRepository;
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

    //mapper add kiya after adding DTO
    private BookingResponseDTO mapToDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();

        dto.setBookingId(booking.getId());
        dto.setCheckIn(booking.getCheckIn());
        dto.setCheckOut(booking.getCheckOut());
        dto.setLastBooked(booking.getBookingTime());

        //frontend me use nhi hai roomID ka
        //dto.setRoomId(booking.getRoom().getId());
        dto.setType(booking.getRoom().getType());
        dto.setPrice(booking.getRoom().getPrice());

        return dto;
    }

    // Logic matches 'bookRoom' frontend wala
    @Transactional
    public boolean createBooking(Long roomId, Booking bookingDetails) {
        Room room = roomRepository.findById(roomId).orElse(null);

        if (room != null && room.getCount() > 0) {

            room.setCount(room.getCount() - 1);
            roomRepository.save(room);

            //histroy ka logic
            bookingDetails.setRoom(room);
            bookingDetails.setBookingTime(LocalDateTime.now());
            bookingRepository.save(bookingDetails);
            return true;
        }
        return false;
    }

    public List<BookingResponseDTO> getHistory() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

}
