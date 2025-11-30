package com.example.slab9.controllers;

import com.example.slab9.DTO.CountryDto;
import com.example.slab9.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping(value = "/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getCountries() {
        List<CountryDto> countryDtoList = countryService.getAllCountries();
        if (countryDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(countryDtoList);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountry(@PathVariable(value = "id") Long id) {
        CountryDto countryDto = countryService.getCountry(id);
        if (Objects.isNull(countryDto)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(countryDto);
        }
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody CountryDto countryDto) {
        CountryDto createdCountry = countryService.addCountry(countryDto);
        return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable(value = "id") Long id, @RequestBody CountryDto countryDto) {
        CountryDto updatedCountry = countryService.updateCountry(id, countryDto);
        if (Objects.isNull(updatedCountry)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(updatedCountry);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable(value = "id") Long id) {
        CountryDto checkCountry = countryService.getCountry(id);
        if (Objects.isNull(checkCountry)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
