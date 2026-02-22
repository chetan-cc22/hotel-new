package com.example.hotel_new.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double price;
    private Integer count; // Inventory count
    private String description;

    @Column(length = 1000)
    private String image;

}
