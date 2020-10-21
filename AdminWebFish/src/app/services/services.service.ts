import { Service } from './../models/Service';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  getList():Observable<Service[]> {
    return this.http.get<Service[]>(this.apiService.URL.services);
  }
  get(id: number): Observable<Service>  {
    const url = `${this.apiService.URL.services}/${id}`;
    return this.http.get<Service>(url);
  }
  add(ser: Service, photo): Observable<Service> {
    const fd = new FormData();
    fd.append('serCode', ser.serCode);
    fd.append('name', ser.name);
    fd.append('price', ser.price.toString());
    fd.append('serTypeId', ser.serviceType.id.toString());
    fd.append('photo', photo);
    return this.http.post<Service>(this.apiService.modifyCreateServicesUrl, fd);
  }
  update(ser: Service, photo): Observable<Service> {
    const fd = new FormData();
    fd.append('serCode', ser.serCode);
    fd.append('name', ser.name);
    fd.append('price', ser.price.toString());
    fd.append('serTypeId', ser.serviceType.id.toString());
    fd.append('photo', photo);
    const url = `${this.apiService.modifyUpdateServicesUrl}/${ser.id}`;
    return this.http.put<Service>(url, fd);
  }
  delete(id: number): Observable<Service>  {
    return this.http.delete<Service>(`${this.apiService.URL.services}/${id}`);
  }
}