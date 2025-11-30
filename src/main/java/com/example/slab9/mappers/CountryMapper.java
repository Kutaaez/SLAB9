package com.example.slab9.mappers;
import com.example.slab9.DTO.CountryDto;
import com.example.slab9.models.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);
    Country toEntity(CountryDto countryDto);
    List<CountryDto> toDtoList(List<Country> countries);
}
