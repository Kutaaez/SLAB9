package com.example.slab9.service.impl;
import com.example.slab9.DTO.CountryDto;
import com.example.slab9.mappers.CountryMapper;
import com.example.slab9.models.Country;
import com.example.slab9.repository.CountryRepository;


import com.example.slab9.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository cRep;
    private final CountryMapper cMap;

    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countries = cRep.findAll();
        return cMap.toDtoList(countries);
    }

    @Override
    public CountryDto getCountry(Long id) {
        Country country = cRep.findById(id).orElse(null);
        return cMap.toDto(country);
    }

    @Override
    public CountryDto addCountry(CountryDto countryDto) {
        Country country = cMap.toEntity(countryDto);
        Country savedCountry = cRep.save(country);
        return cMap.toDto(savedCountry);
    }

    @Override
    public CountryDto updateCountry(Long id, CountryDto countryDto) {
        Country checkCountry = cRep.findById(id).orElse(null);
        if (checkCountry == null) {
            return null;
        }
        Country country = cMap.toEntity(countryDto);
        country.setId(id);
        Country updatedCountry = cRep.save(country);
        return cMap.toDto(updatedCountry);
    }

    @Override
    public void deleteCountry(Long id) {
        cRep.deleteById(id);
    }

}
