import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import *as myUrl from '../../environments/environment';
import { Region } from '../model/region';
@Injectable({
  providedIn: 'root'
})
export class RegionService {
  regiones:Region[];
  selectRegion:Region;
  selectRegiononly:Region;
  readonly API_URL=myUrl.environment.endpoint+'/api/regiones';

  constructor(private http: HttpClient) { 
    this.regiones=new Array<Region>();
    this.selectRegion=new Region();
    this.selectRegiononly=new Region();
  }
  //obtener regiones
  getRegions(){
    return this.http.get(this.API_URL);
  }

}
