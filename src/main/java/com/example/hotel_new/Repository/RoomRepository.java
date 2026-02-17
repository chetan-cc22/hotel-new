package com.example.hotel_new.Repository;

import com.example.hotel_new.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    // Used to find existing rooms to merge inventory
    Optional<Room> findByTypeIgnoreCase(String type);
}
