package com.example.slab9.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Country manufacturer;
}
