package com.gps.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.dao.CountryDao;
import com.gps.model.Country;

import javax.transaction.Transactional;

@Service("countryService")
@Transactional
public class CountryServiceImplement implements CountryService{
    @Autowired
    private CountryDao countryDao;
    @Override
    public List<Country> findCountryByRegion(Long codRegion) {
        // TODO Auto-generated method stub
        return countryDao.findCountryByRegion(codRegion);
    }

}
