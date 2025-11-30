package com.example.slab9.service;

import com.example.slab9.DTO.ItemDto;
import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();
    ItemDto getItem(Long id);
    ItemDto addItemWithManufacturer(ItemDto itemDto, Long manufacturerId);
    ItemDto updateItem(Long id, ItemDto itemDto);
    void deleteItem(Long id);
}
