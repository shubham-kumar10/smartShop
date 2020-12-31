import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean;
  error: string = "Login Failed"

  constructor(private formBuild: FormBuilder, private _authService: AuthenticationService, private router: Router, private productService: ProductService) { }

  ngOnInit() {
    this.loginForm = this.formBuild.group({
      username: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required
      ]]
    })
    this._authService.pending = false;
    this._authService.declined = false;
  }
  get username() {
    return this.loginForm.get('username');
  }
  get password() {
    return this.loginForm.get('password');
  }

  getUsername() {
    return this.loginForm.value['username'];
  }

  getPassword() {
    return this.loginForm.value['password'];
  }

  toSignup() {
    this.router.navigate(['signup'])
  }
  onSubmit() {
    this._authService.authenticate(this.getUsername(), this.getPassword()).subscribe(
      data => {
        console.log(data);
        if (data.status == "A") {
          this._authService.setToken(data.token);
          this.error = "Logged In successfully";
          this._authService.username = this.getUsername();
          this._authService.loggedIn = true;
          this._authService.validCredentials = true;
          this.router.navigate(['/search-bar'])
          if (data.role == "ADMIN" && data.status == "A") {
            this.productService.isAdmin = true;
            console.log("in if" + this.productService.isAdmin)
          }
          else if (data.role == "SUPER") {
            this.productService.isSuper = true;
            this.router.navigate(['/pending'])
          }
          else {
            this.productService.isAdmin = false;
          }
          console.log(data.role);
          console.log("logged");
          console.log(this._authService.loggedIn);
          // 
          console.log(data.token);
          console.log(data.role);
        }
        else {
          this._authService.loggedIn = false;
          this._authService.pending = true ? data.status == "P" : false;
          this._authService.declined = true ? data.status == "D" : false;
        }
      },
      error => {
        this._authService.validCredentials = false;
        this.invalidLogin = true
        if (error.status == 401)
          this.error = "Invalid Username or Password";
        console.log(error);
      }
    );
  }
}
