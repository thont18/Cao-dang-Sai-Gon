import { Bill } from './../models/bill';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor() { }
  baseURL = 'http://localhost:7777/';
  URL = {
    searchFish : this.baseURL + 'searchProducts',
    searchFishType : this.baseURL + 'searchProductTypes',
    customers : this.baseURL + 'customers',
    products : this.baseURL + 'fish/getAllFish',
    productsOne : this.baseURL + 'fish/getOneFish',
    deleteFish : this.baseURL + 'fish/deleteFish',
    services : this.baseURL + 'service',
    productTypes : this.baseURL + 'fishTypes',
    serviceTypes : this.baseURL + 'serviceTypes',
    bills: this.baseURL + 'bills'
  };

  modifyCreateProductsUrl = 'http://localhost:7777/fish/createFish';
  modifyUpdateProductsUrl = 'http://localhost:7777/fish/updateFish';
  modifyUpdateProductNoPhotosUrl = 'http://localhost:7777/fish/updateFishNoImage';
  modifyCreateServicesUrl = 'http://localhost:7777/service/createService';
  modifyUpdateServicesUrl = 'http://localhost:7777/service/updateService';
}
