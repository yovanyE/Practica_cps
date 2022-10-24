import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/model/country';
import { Region } from 'src/app/model/region';
import { CountryService } from 'src/app/service/country.service';
import { RegionService } from 'src/app/service/region.service';
import { NgForm } from '@angular/forms';
import { Order } from 'src/app/model/order';
import { OrderService } from 'src/app/service/order.service';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
   public countryDefault:string="Guatemala";
   public rate?:number=0.0;
   public estimate?:number=0.0;
   private region:Region;
   private order:Order;
   private country:Country;
  constructor(public regionService: RegionService, public countryService: CountryService
    ,public orderService:OrderService) {
    this.region=new Region();
    this.order=new Order();
    this.country=new Country();
   }

  ngOnInit(): void {
    this.getRegion();

  }
  getRegion(){
    this.regionService.getRegions()
    .subscribe(res=>{
      this.regionService.regiones=res as Region[];
    });
  }
  onChangeCountryDes(region:Region){
    this.regionService.selectRegiononly=region;
    console.log(region.codeRegion);
    this.countryService.getCountryByRegion(region.codeRegion)
    .subscribe(res=>{
      this.countryService.countrys=res as Country[];
      
    });
  }
  onchangeCountry(country:Country){
    this.countryService.selectCountryonly=country;
    this.rate=country.rates;
  }
  sendOrder(form:NgForm){
    this.region=new Region(this.regionService.selectRegiononly.codeRegion,this.regionService.selectRegiononly.description);
    this.country=new Country(this.countryService.selectCountryonly.codCountry,'',0,this.region);
    this.order=new Order(1,form.value.weight,form.value.width,form.value.rate,form.value.longg,form.value.rate,form.value.quotation,form.value.paisOrigen,this.country);

    this.orderService.sendOrder(this.order).
    subscribe(res=>{
      console.log(res);
    });
    //console.log(this.region);
    //console.log(form.value.codCountry);
    //console.log(form.value.codCountry.region);

  }
  getcotiza(form:NgForm){
    //console.log(form.value);
    var objet={
      weight:form.value.weight,
      width:form.value.width,
      tall:form.value.tall,
      longg:form.value.longg,
      rate:form.value.rate
    }
    console.log(objet);
    this.orderService.getEstimate(objet)
    .subscribe(res=>{
      console.log(res);
      this.orderService.selectOrder.quotation=Number(res);
    });
  }


}
