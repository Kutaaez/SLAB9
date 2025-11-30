package com.example.slab9.mappers;

import com.example.slab9.DTO.CountryDto;
import com.example.slab9.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryMapperTest {

    @Autowired
    private CountryMapper countryMapper;

    @Test
    void testToDto() {
        Country country = new Country();
        country.setId(1L);
        country.setName("Test Country");
        country.setCode("TC");

        CountryDto dto = countryMapper.toDto(country);
        Assertions.assertEquals(country.getName(), dto.getName());
        Assertions.assertEquals(country.getCode(), dto.getCode());
    }

    @Test
    void testToEntity() {
        CountryDto dto = new CountryDto();
        dto.setName("Entity Test");
        dto.setCode("ET");

        Country country = countryMapper.toEntity(dto);
        Assertions.assertEquals(dto.getName(), country.getName());
        Assertions.assertEquals(dto.getCode(), country.getCode());
    }
}