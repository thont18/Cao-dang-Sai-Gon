import { Observable } from 'rxjs';
import { ServiceType } from './../models/ServiceType';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceTypeService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  getList():Observable<[ServiceType]> {
    return this.http.get<[ServiceType]>(this.apiService.URL.serviceTypes);
  }
  delete(id: number): Observable<ServiceType>  {
    return this.http.delete<ServiceType>(`${this.apiService.URL.serviceTypes}/${id}`);
  }
  get(id: number): Observable<ServiceType>  {
    const url = `${this.apiService.URL.serviceTypes}/${id}`;
    return this.http.get<ServiceType>(url);
  }
  add(serType: ServiceType): Observable<ServiceType> {
    return this.http.post<ServiceType>(this.apiService.URL.serviceTypes, serType);
  }
  update(serType: ServiceType): Observable<ServiceType> {
    const url = `${this.apiService.URL.serviceTypes}/${serType.id}`;
    return this.http.put<ServiceType>(url, serType);
  }
}
