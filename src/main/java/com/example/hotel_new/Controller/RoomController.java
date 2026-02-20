package com.example.hotel_new.Controller;

import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.ModelDTO.RoomDTO;
import com.example.hotel_new.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")    //aaj hi sikhaya crossorigin ka
@CrossOrigin(origins = "*")   /// angular frontend manav ke liye
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addOrUpdateRoom(room);
    }


    @PatchMapping("/{id}/reduce")
    public void reduceQuantity(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body) {
        roomService.deleteRoomQuantity(id, body.get("quantity"));
    }

//    @DeleteMapping("/{id}/{qty}")
//    public void deleteQuantity(@PathVariable Long id, @PathVariable int qty) {
//        roomService.deleteRoomQuantity(id, qty);
//    }

      // postmapping add room method is changed in this controller
}
