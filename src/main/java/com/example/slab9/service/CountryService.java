package com.example.slab9.service;
import com.example.slab9.models.Country;

import java.util.List;
public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Long id);
}
