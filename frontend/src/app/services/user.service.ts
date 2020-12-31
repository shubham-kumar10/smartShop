import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = environment.baseUrl;
  userType: string;
  constructor(private router: Router, private _httpClient: HttpClient, private _authService: AuthenticationService) { }

  addUser(user: User): Observable<any> {
    //this.userList.push(user);
    console.log("Inside add user of service ")
    console.log(user)
    // return this._httpClient.post<any>(this.url + "signUp-service/register", user)
    return this._httpClient.post<any>(this.url + "register", user)
    this.router.navigate(['login']);
  }

  public getPendingUsers(): Observable<any> {
    let headers = new HttpHeaders();
    console.log("token generated at getAllMovies()" + this._authService.getToken());
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    console.log("Movies requested");
    return this._httpClient.get<User[]>(this.url + "admin/requests/", { headers });
  }

  public updateStatus(user: User): Observable<any> {
    console.log("Inside update status");
    console.log(user);
    let headers = new HttpHeaders();
    console.log("token generated at Save()" + this._authService.getToken());
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    return this._httpClient.put<User>(this.url + "admin/", user, { headers });
  }

  getUser(user: string): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this._authService.getToken());
    return this._httpClient.get<User>(this.url + "admin/" + user, { headers });
  }
}