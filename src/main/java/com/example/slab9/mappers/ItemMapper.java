package com.example.slab9.mappers;
import com.example.slab9.DTO.ItemDto;
import com.example.slab9.models.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toEntity(ItemDto itemDto);
    List<ItemDto> toDtoList(List<Item> items);
}
