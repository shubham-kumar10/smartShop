import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private _httpClient: HttpClient, public router: Router) { }

  loggedInUser = { loggedOut: true };
  validCredentials: boolean = true;
  accessToken: string; // JWT token
  loggedIn: boolean = false;
  private authenticationApiUrl = environment.baseUrl;
  //private authenticationApiUrl = environment.baseUrl + 'smart-shop/';
  private token: string;
  username: string;
  pending: boolean = false;
  declined: boolean = false;

  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  authenticate(user: string, password: string): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + btoa(user + ':' + password));
    return this._httpClient.get(this.authenticationApiUrl + "authenticate", { headers })
  }

  logout() {
    this.loggedIn = false;
    this.setToken(null);
    this.router.navigate(['/welcome'])
  }

}
