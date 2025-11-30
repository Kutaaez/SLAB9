package com.example.slab9.DTO;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private CountryDto manufacturer;
}