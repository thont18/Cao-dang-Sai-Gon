import { ApiService } from './api.service';
import { Customer } from './../models/Customer';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private apiService: ApiService, private http: HttpClient) {}

  getList():Observable<[Customer]> {
    return this.http.get<[Customer]>(this.apiService.URL.customers);
  }
  get(id: number): Observable<Customer>  {
    const url = `${this.apiService.URL.customers}/${id}`;
    return this.http.get<Customer>(url);
  }
  add(cus: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.apiService.URL.customers, cus);
  }
  update(cus: Customer): Observable<Customer> {
    const url = `${this.apiService.URL.customers}/${cus.id}`;
    return this.http.put<Customer>(url, cus);
  }
  delete(id: number): Observable<Customer>  {
    return this.http.delete<Customer>(`${this.apiService.URL.customers}/${id}`);
  }
}
