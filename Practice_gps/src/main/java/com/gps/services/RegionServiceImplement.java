package com.gps.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.gps.dao.RegionDao;
import com.gps.model.Region;
@Service("regionService")
@Transactional
public class RegionServiceImplement implements RegionService{
    @Autowired
    private RegionDao regionDao;
    @Override
    public List<Region> findAllRegion() {
        // TODO Auto-generated method stub
        return regionDao.findAllRegion();
    }
    
}
