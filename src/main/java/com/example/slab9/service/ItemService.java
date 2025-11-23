package com.example.slab9.service;

import com.example.slab9.models.Item;
import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item addItemWithManufacturer(Item item, Long manufacturerId);
    void deleteItem(Long id);
}
