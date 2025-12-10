package com.example.slab9.mappers;

import com.example.slab9.DTO.CountryDto;
import com.example.slab9.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    void testToDtoList() {
        Country c1 = new Country();
        c1.setName("Spain");
        c1.setCode("SPA");
        Country c2 = new Country();
        c2.setName("Uzbekistan");
        c2.setCode("CB");

        List<Country> countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);
        List<CountryDto> dtos = countryMapper.toDtoList(countries);
        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(2, dtos.size());
        Assertions.assertEquals("Spain", dtos.get(0).getName());
        Assertions.assertEquals("Uzbekistan", dtos.get(1).getName());
    }
}