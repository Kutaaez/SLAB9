package com.example.slab9.service;
import com.example.slab9.DTO.CountryDto;

import java.util.List;
public interface CountryService {
    List<CountryDto> getAllCountries();
    CountryDto getCountry(Long id);
    CountryDto addCountry(CountryDto countryDto);
    CountryDto updateCountry(Long id, CountryDto countryDto);
    void deleteCountry(Long id);
}
