package com.example.slab9.service.impl;
import com.example.slab9.service.ItemService;
import com.example.slab9.DTO.ItemDto;
import com.example.slab9.models.*;
import com.example.slab9.repository.*;
import com.example.slab9.mappers.ItemMapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository iRep;
    private final CountryRepository cRep;
    private final ItemMapper iMap;
    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = iRep.findAll();
        return iMap.toDtoList(items);
    }

    @Override
    public ItemDto getItem(Long id) {
        Item item = iRep.findById(id).orElse(null);
        return iMap.toDto(item);
    }

    @Override
    public ItemDto addItemWithManufacturer(ItemDto itemDto, Long manufacturerId) {
        Item item = iMap.toEntity(itemDto);
        Country country = cRep.findById(manufacturerId).orElse(null);
        if (country != null) {
            item.setManufacturer(country);
        }
        Item savedItem = iRep.save(item);
        return iMap.toDto(savedItem);
    }

    @Override
    public void deleteItem(Long id) {
        iRep.deleteById(id);
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item checkItem = iRep.findById(id).orElse(null);
        if (checkItem == null) {
            return null;
        }
        Item item = iMap.toEntity(itemDto);
        item.setId(id);
        if (item.getManufacturer() == null && checkItem.getManufacturer() != null) {
            item.setManufacturer(checkItem.getManufacturer());
        }

        Item savedItem = iRep.save(item);
        return iMap.toDto(savedItem);
    }
}
