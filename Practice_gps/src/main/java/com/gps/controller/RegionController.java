package com.gps.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import com.gps.model.Region;
import com.gps.services.RegionService;
@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class RegionController {
    @Autowired
    private RegionService regionService;
	@RequestMapping(value="/regiones",method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Region>> getRegion(@RequestParam(value ="region", required = false) String descripcion){
			List<Region> regions = new ArrayList<Region>();
			if(descripcion == null) {
				regions = regionService.findAllRegion();
				if(regions.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}else {
					return new ResponseEntity<List<Region>>(regions,HttpStatus.OK);
				}
			}
		 
			return new ResponseEntity<List<Region>>(regions,HttpStatus.OK);
		}
}
