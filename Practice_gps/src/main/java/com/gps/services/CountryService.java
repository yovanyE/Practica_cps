package com.gps.services;

import java.util.List;

import com.gps.model.Country;

public interface CountryService {
    List<Country> findCountryByRegion(Long codRegion);
}
