import {Region} from './region'
export class Country {
	codCountry?:number;
    description?:string;
    rates?:number;
    region?: Region;
    constructor(codCountry?:number,description?:string,rates?:number,region?:Region){
        this.codCountry=codCountry;
        this.description=description;
        this.rates=rates;
        this.region=region;
    }
}
