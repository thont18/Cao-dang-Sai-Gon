import { ProductType } from './../models/ProductType';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  getList(): Observable<[ProductType]> {
    return this.http.get<[ProductType]>(this.apiService.URL.productTypes);
  }
  delete(id: number): Observable<ProductType>  {
    return this.http.delete<ProductType>(`${this.apiService.URL.productTypes}/${id}`);
  }
  get(id: number): Observable<ProductType>  {
    const url = `${this.apiService.URL.productTypes}/${id}`;
    return this.http.get<ProductType>(url);
  }
  add(proType: ProductType): Observable<ProductType> {
    return this.http.post<ProductType>(this.apiService.URL.productTypes, proType);
  }
  update(proType: ProductType): Observable<ProductType> {
    const url = `${this.apiService.URL.productTypes}/${proType.id}`;
    return this.http.put<ProductType>(url, proType);
  }
}
