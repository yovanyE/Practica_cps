package com.gps.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.gps.model.Region;
@Repository
@Transactional
public class RegionDaoImplement extends AbstractSession implements RegionDao{

    @Override
    public List<Region> findAllRegion() {
        // TODO Auto-generated method stub
        return getSession().createQuery("from Region").list();
    }
    
}
