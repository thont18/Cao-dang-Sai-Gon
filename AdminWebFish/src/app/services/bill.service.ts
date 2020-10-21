import { Observable } from 'rxjs';
import { Bill } from './../models/bill';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  constructor(private apiService: ApiService, private http: HttpClient) {}

  getList():Observable<[Bill]> {
    return this.http.get<[Bill]>(this.apiService.URL.bills);
  }
}
