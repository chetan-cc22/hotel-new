package com.example.hotel_new.Controller;

import com.example.hotel_new.Entity.Room;
import com.example.hotel_new.ModelDTO.RoomDTO;
import com.example.hotel_new.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //abhi banaya yeh (admin ke liye)
    @PostMapping
    public ResponseEntity<?> addRoom(
            @RequestHeader("role") String role,
            @RequestBody Room room) {

        if (!role.equalsIgnoreCase("admin")) {
            return ResponseEntity.status(403).body("Access Denied: Admin Only");
        }

        return ResponseEntity.ok(roomService.addOrUpdateRoom(room));
    }


    //reduce quantity wala loic for admin
    @PatchMapping("/{id}/reduce")
    public ResponseEntity<?> reduceQuantity(
            @RequestHeader("role") String role,
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body) {

        if (!role.equalsIgnoreCase("admin")) {
            return ResponseEntity.status(403).body("Access Denied: Admin Only");
        }

        roomService.deleteRoomQuantity(id, body.get("quantity"));
        return ResponseEntity.ok("Quantity Updated");
    }


    //delete room admin wala yeh bhi
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(
            @RequestHeader("role") String role,
            @PathVariable Long id) {

        if (!role.equalsIgnoreCase("admin")) {
            return ResponseEntity.status(403).body("Access Denied: Admin Only");
        }

        roomService.deleteRoom(id);
        return ResponseEntity.ok("Room Deleted");
    }

}
