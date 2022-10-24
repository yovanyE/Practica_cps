package com.gps.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.gps.model.Country;
@Repository
@Transactional
public class CountryDaoImplement extends AbstractSession implements CountryDao{

    @Override
    public List<Country> findCountryByRegion(Long codRegion) {
        // TODO Auto-generated method stub
        return getSession().createQuery("from Country where region.codeRegion = :codRegion")
        .setParameter("codRegion",codRegion)
        .list();
    }
    
}
