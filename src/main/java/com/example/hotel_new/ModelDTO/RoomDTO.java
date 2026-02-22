package com.example.hotel_new.ModelDTO;

import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private String type;
    private Double price;
    private Integer count;
    private String description;
    private String image;

}
