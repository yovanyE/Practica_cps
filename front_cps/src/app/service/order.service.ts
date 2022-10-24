import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import *as myUrl from '../../environments/environment';
import { Order } from '../model/order';
import { Region } from '../model/region';
@Injectable({
  providedIn: 'root'
})
export class OrderService {
  regiones:Region[];
  selectOrder:Order;
  readonly API_URL=myUrl.environment.endpoint+'/api/orders';

  constructor(private http: HttpClient) { 
    this.regiones=new Array<Region>();
    this.selectOrder=new Order();
  }

  //enviar orden
  sendOrder(order:Order){
   return this.http.post(this.API_URL,order);
  }
  //calcular cotizacion
  getEstimate(objet:any){
    return this.http.post(this.API_URL+'/cotiza',objet);
  }
}
