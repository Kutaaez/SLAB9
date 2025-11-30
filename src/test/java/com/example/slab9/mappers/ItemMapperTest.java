package com.example.slab9.mappers;

import com.example.slab9.DTO.ItemDto;
import com.example.slab9.models.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    void testToDto() {
        Item item = new Item();
        item.setName("Test Item");
        item.setPrice(100);

        ItemDto dto = itemMapper.toDto(item);
        Assertions.assertEquals(item.getName(), dto.getName());
        Assertions.assertEquals(item.getPrice(), dto.getPrice());
    }

    @Test
    void testToEntity() {
        ItemDto dto = new ItemDto();
        dto.setName("Phone");
        dto.setPrice(999);

        Item item = itemMapper.toEntity(dto);
        Assertions.assertEquals(dto.getName(), item.getName());
        Assertions.assertEquals(dto.getPrice(), item.getPrice());
    }
}