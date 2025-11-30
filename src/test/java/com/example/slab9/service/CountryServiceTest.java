package com.example.slab9.service;

import com.example.slab9.DTO.CountryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void testCRUD() {
        CountryDto newCountry = new CountryDto();
        newCountry.setName("Canada");
        newCountry.setCode("CA");
        CountryDto saved = countryService.addCountry(newCountry);
        Assertions.assertNotNull(saved.getId());

        CountryDto found = countryService.getCountry(saved.getId());
        Assertions.assertEquals("Canada", found.getName());

        found.setName("Canada Updated");
        CountryDto updated = countryService.updateCountry(found.getId(), found);
        Assertions.assertEquals("Canada Updated", updated.getName());

        List<CountryDto> list = countryService.getAllCountries();
        Assertions.assertFalse(list.isEmpty());

        countryService.deleteCountry(saved.getId());
        CountryDto deleted = countryService.getCountry(saved.getId());
        Assertions.assertNull(deleted);
    }
}