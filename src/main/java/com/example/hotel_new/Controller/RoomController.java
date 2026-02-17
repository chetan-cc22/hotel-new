package com.example.hotel_new.Controller;

import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.ModelDTO.RoomDTO;
import com.example.hotel_new.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")    //aaj hi sikhaya crossorigin ka
@CrossOrigin(origins = "http://localhost:4200")   /// angular frontend manav ke liye
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addOrUpdateRoom(room);
    }

    @DeleteMapping("/{id}/{qty}")
    public void deleteQuantity(@PathVariable Long id, @PathVariable int qty) {
        roomService.deleteRoomQuantity(id, qty);
    }

}
