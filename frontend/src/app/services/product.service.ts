import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { HttpHeaders } from '@angular/common/http';
import { Product } from '../model/Product';
import { Bill } from '../model/Bill';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  isAdmin: boolean = false;
  isSuper: boolean = false;
  addedToFavorites: boolean = false;
  FavoritesAddedId: number;
  isLoggedIn: boolean = false;
  clickedOnAdd: boolean = false;
  private subject = new Subject<Product[]>();
  // url = environment.baseUrl + 'smart-shop/';
  url = environment.baseUrl
  editClicked: boolean = false;
  billing: boolean = false;
  quantity: number = 0;

  constructor(private _httpClient: HttpClient, private _authService: AuthenticationService) { }

  public getAllProducts(): Observable<any> {
    let headers = new HttpHeaders();
    console.log("token generated at getAllProducts()" + this._authService.getToken());
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    console.log("Products requested");
    return this._httpClient.get<Product[]>(this.url + "list", { headers });
  }

  getSubject(): Subject<Product[]> {
    return this.subject;
  }

  getProduct(code: string): Observable<any> {
    let headers = new HttpHeaders();
    console.log("token generated at getProduct()" + this._authService.getToken());
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    console.log("Product for customer requested");
    return this._httpClient.get<Product>(this.url + "list/" + code, { headers });
  }

  save(Product: Product): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    return this._httpClient.post<Product>(this.url + "list/add", Product, { headers });
  }

  edit(Product: Product): Observable<any> {
    console.log("Inside Product edit");
    console.log(Product);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    console.log("Product update requested");
    return this._httpClient.put<Product>(this.url + "list", Product, { headers });
  }

  delete(code: string): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    console.log("Product delete requested");
    return this._httpClient.delete<Product>(this.url + "list/" + code, { headers });
  }

  addBill(bill: Bill): Observable<any> {
    console.log(bill)
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    return this._httpClient.post(this.url + "bill/add", bill, { headers })
  }
}
