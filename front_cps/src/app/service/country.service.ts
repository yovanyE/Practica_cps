import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import *as myUrl from '../../environments/environment';
import { Country } from '../model/country';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  selectCountry:Country;
  countrys:Country[];
  selectCountryonly:Country;
  readonly API_URL=myUrl.environment.endpoint+'/api/country';

  constructor(private http: HttpClient) { 
    this.countrys=new Array<Country>();
    this.selectCountry=new Country();
    this.selectCountryonly=new Country();
  }
  getCountryByRegion(id:number){
    return this.http.get(this.API_URL+`/${id}`);
  }

}
