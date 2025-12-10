package com.example.slab9.mappers;

import com.example.slab9.DTO.ItemDto;
import com.example.slab9.models.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
    @Test
    void testToDtoList() {
        Item i1 = new Item();
        i1.setName("Item 1");
        i1.setPrice(10);

        Item i2 = new Item();
        i2.setName("Item 2");
        i2.setPrice(20);

        List<Item> items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
        List<ItemDto> dtos = itemMapper.toDtoList(items);
        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(2, dtos.size());
        Assertions.assertEquals("Item 1", dtos.get(0).getName());
        Assertions.assertEquals("Item 2", dtos.get(1).getName());
        Assertions.assertEquals(10, dtos.get(0).getPrice());
    }
    }
