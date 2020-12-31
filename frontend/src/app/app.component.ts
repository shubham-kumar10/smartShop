import { Component } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';
import { Router } from '@angular/router';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'smartShop';

  ngOnInit(): void {
    this.loggedIn();
    this.router.navigate(['welcome']);
  }
  constructor(private authService: AuthenticationService, public router: Router, private productService: ProductService) {
  }


  isLoggedIn: boolean = false;

  clickOnAddFavorite() {
    this.productService.clickedOnAdd = false;
    this.productService.addedToFavorites = false;
  }

  loggedIn(): boolean {
    if (this.authService.loggedIn) {
      this.isLoggedIn = true;
      return true
    }
    else {
      this.isLoggedIn = false;
      return false;
    }
  }
  clickOnAddCart() {
    this.productService.clickedOnAdd = false;
    this.productService.addedToFavorites = false;
  }
  exit() {
    window.location.reload();
  }
}
