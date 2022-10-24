package com.gps.dao;

import java.util.List;

import com.gps.model.Country;

public interface CountryDao {
    List<Country> findCountryByRegion(Long codRegion);
}
