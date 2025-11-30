package com.example.slab9.controllers;
import com.example.slab9.DTO.ItemDto;
import com.example.slab9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> getItems() {
        List<ItemDto> itemDtoList = itemService.getAllItems();
        if (itemDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(itemDtoList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getItem(@PathVariable(value = "id") Long id) {
        ItemDto itemDto = itemService.getItem(id);
        if (Objects.isNull(itemDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(itemDto);
        }
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto,
                                     @RequestParam(value = "manufacturerId") Long manufacturerId) {
        ItemDto createdItem = itemService.addItemWithManufacturer(itemDto, manufacturerId);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(value = "id") Long id) {
        ItemDto checkItem = itemService.getItem(id);
        if (Objects.isNull(checkItem)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
