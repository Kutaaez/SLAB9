package com.example.slab9.service;

import com.example.slab9.DTO.CountryDto;
import com.example.slab9.DTO.ItemDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CountryService countryService;

    @Test
    void testItemFlow() {
        CountryDto c = new CountryDto();
        c.setName("Japan");
        c.setCode("JP");
        CountryDto manufacturer = countryService.addCountry(c);

        ItemDto item = new ItemDto();
        item.setName("PlayStation 5");
        item.setPrice(500);
        item.setQuantity(10);

        ItemDto savedItem = itemService.addItemWithManufacturer(item, manufacturer.getId());
        Assertions.assertNotNull(savedItem.getId());

        ItemDto found = itemService.getItem(savedItem.getId());
        Assertions.assertEquals("PlayStation 5", found.getName());

        found.setPrice(450);
        ItemDto updated = itemService.updateItem(found.getId(), found);
        Assertions.assertEquals(450, updated.getPrice());

        itemService.deleteItem(savedItem.getId());
        Assertions.assertNull(itemService.getItem(savedItem.getId()));
    }
}