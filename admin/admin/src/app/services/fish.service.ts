import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FishService {
  constructor() {}
  // photo: File;
  // getList():Observable<[Product]> {
  //   return this.http.get<[Product]>(this.apiService.URL.products);
  // }
  // delete(id: number): Observable<Product>  {
  //   return this.http.delete<Product>(`${this.apiService.URL.products}/${id}`);
  // }
  // get(id: number): Observable<Product>  {
  //   const url = `${this.apiService.URL.products}/${id}`;
  //   return this.http.get<Product>(url);
  // }
  // add(pro: Product, photo): Observable<Product> {
  //   const fd = new FormData();
  //   fd.append('proCode', pro.proCode);
  //   fd.append('name', pro.name);
  //   fd.append('price', pro.price.toString());
  //   fd.append('proTypeId', pro.productType.id.toString());
  //   fd.append('photo', photo);
  //   return this.http.post<Product>(this.apiService.modifyCreateProductsUrl, fd);
  //
  // }
  // update(pro: Product, photo): Observable<Product> {
  //   const fd = new FormData();
  //   fd.append('proCode', pro.proCode);
  //   fd.append('name', pro.name);
  //   fd.append('price', pro.price.toString());
  //   fd.append('proTypeId', pro.productType.id.toString());
  //   fd.append('photo', photo);
  //   const url = `${this.apiService.modifyUpdateProductsUrl}/${pro.id}`;
  //   return this.http.put<Product>(url, fd);
  // }
  //
  // updateNoPhoto(pro: Product): Observable<Product> {
  //   const fd = new FormData();
  //   fd.append('proCode', pro.proCode);
  //   fd.append('name', pro.name);
  //   fd.append('price', pro.price.toString());
  //   fd.append('proTypeId', pro.productType.id.toString());
  //   const url = `${this.apiService.modifyUpdateProductNoPhotosUrl}/${pro.id}`;
  //   return this.http.put<Product>(url, fd);
  // }
  // // update(pro: Product): Observable<Product> {
  // //   const url = `${this.apiService.URL.products}/${pro.id}`;
  // //   return this.http.put<Product>(url, pro);
  // // }
  // uploadImage(data: FormData): Observable<String> {
  //   return this.http.post<String>(`${this.apiService.baseURL}uploadFile`, data);
  // }

}
