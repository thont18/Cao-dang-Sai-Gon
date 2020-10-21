
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private apiService: ApiService, private http: HttpClient) {}
  photo: File;
  getList(): Observable<[Product]> {
    return this.http.get<[Product]>(this.apiService.URL.products);
  }
  delete(id: number): Observable<Product>  {
    return this.http.delete<Product>(`${this.apiService.URL.deleteFish}/${id}`);
  }
  get(id: number): Observable<Product>  {
    const url = `${this.apiService.URL.productsOne}/${id}`;
    return this.http.get<Product>(url);
  }
  add(pro, photo): Observable<Product> {
    const fd = new FormData();
    fd.append('proCode', pro.proCode);
    fd.append('name', pro.name);
    fd.append('price', pro.price.toString());
    fd.append('proTypeId', pro.productType.id.toString());
    fd.append('photo', photo);
    fd.append('description', pro.description);
    fd.append('createdBy', pro.createdBy);
    fd.append('modifiedBy', pro.modifiedBy);
    fd.append('dateCreated', pro.dateCreated);
    fd.append('dateModified', pro.dateModified);
    return this.http.post<Product>(this.apiService.modifyCreateProductsUrl, fd);

  }
  update(pro, photo): Observable<Product> {
    const fd = new FormData();
    fd.append('proCode', pro.proCode);
    fd.append('name', pro.name);
    fd.append('price', pro.price.toString());
    fd.append('proTypeId', pro.productType.id.toString());
    fd.append('photoEdit', photo);
    fd.append('description', pro.description);
    fd.append('createdBy', pro.createdBy);
    fd.append('modifiedBy', pro.modifiedBy);
    fd.append('dateCreated', pro.dateCreated);
    fd.append('dateModified', pro.dateModified);
    const url = `${this.apiService.modifyUpdateProductsUrl}/${pro.id}`;
    return this.http.put<Product>(url, fd);
  }

  updateNoPhoto(pro): Observable<Product> {
    const fd = new FormData();
    fd.append('proCode', pro.proCode);
    fd.append('name', pro.name);
    fd.append('price', pro.price.toString());
    fd.append('proTypeId', pro.productType.id.toString());
    fd.append('description', pro.description);
    fd.append('createdBy', pro.createdBy);
    fd.append('modifiedBy', pro.modifiedBy);
    fd.append('dateCreated', pro.dateCreated);
    fd.append('dateModified', pro.dateModified);
    const url = `${this.apiService.modifyUpdateProductNoPhotosUrl}/${pro.id}`;
    return this.http.put<Product>(url, fd);
  }
  // update(pro: Product): Observable<Product> {
  //   const url = `${this.apiService.URL.products}/${pro.id}`;
  //   return this.http.put<Product>(url, pro);
  // }
  uploadImage(data: FormData): Observable<String> {
    return this.http.post<String>(`${this.apiService.baseURL}uploadFile`, data);
  }
}
