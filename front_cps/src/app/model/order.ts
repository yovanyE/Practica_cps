import { Country } from "./country";

export class Order {
	codOrder?:number;
	weight?:number;
    width?:number;
    tall?:number;
    longg?:number;
    rate?:number;
    quotation?:number;
    originCountry?:string;
    countryDestination?:Country;
    constructor(codOrder?:number,weight?:number,width?:number,tall?:number,longg?:number,rate?:number,quotation?:number,originCountry?:string,countryDestination?:Country){
        this.codOrder=codOrder;
        this.weight=weight;
        this.width=width;
        this.tall=tall;
        this.longg=longg;
        this.rate=rate;
        this.quotation=quotation;
        this.originCountry=originCountry;
        this.countryDestination=countryDestination;
    }
}

