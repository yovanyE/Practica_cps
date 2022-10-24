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

import com.gps.model.Country;
import com.gps.services.CountryService;
@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private CountryService countryService;
	@RequestMapping(value="/country/{codRegion}",method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Country>> getCountryByRegion(@PathVariable("codRegion") Long codeRegion){
			List<Country> countrys = new ArrayList<Country>();
			if(codeRegion == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
            countrys = countryService.findCountryByRegion(codeRegion);
            if(countrys.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Country>>(countrys,HttpStatus.OK);
		}
}
