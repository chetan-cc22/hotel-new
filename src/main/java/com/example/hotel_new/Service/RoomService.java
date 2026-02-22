package com.example.hotel_new.Service;

import com.example.hotel_new.ModelDTO.RoomDTO;
import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    //method for DTO RoomDTO
    private RoomDTO mapToDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setType(room.getType());
        dto.setPrice(room.getPrice());
        dto.setCount(room.getCount());
        dto.setDescription(room.getDescription());
        dto.setImage(room.getImage());
        return dto;
    }

    //update kiya after adding DTO
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Logic matches 'addRoom' frontend wala code se
    public Room addOrUpdateRoom(Room newRoom) {
        Optional<Room> existing = roomRepository.findByTypeIgnoreCase(newRoom.getType());

        if (existing.isPresent()) {
            Room room = existing.get();
            room.setCount(room.getCount() + newRoom.getCount()); // Merge quantity

            return roomRepository.save(room);
        } else {
            return roomRepository.save(newRoom);
        }
    }


    public void deleteRoomQuantity(Long id, int qty) {
        Optional<Room> roomOpt = roomRepository.findById(id);
        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            int newCount = room.getCount() - qty;

            if (newCount <= 0) {
                roomRepository.deleteById(id); // Remove if 0
            } else {
                room.setCount(newCount);
                roomRepository.save(room);
            }
        }
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

}
