import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../model/Product';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchKey: string;
  sortKey: string;
  itemList: Product[];
  filteredItemList: Product[];
  isAdmin: boolean;
  constructor(private _product: ProductService) { }
  ngOnInit() {
    this._product.billing = false;
    this._product.getAllProducts().subscribe(
      data => {
        this.itemList = data;
        this.filteredItemList = this.itemList;
      }
    )
  }

  delete(code: string) {
    this._product.delete(code).subscribe(
      data => {
        this.itemList = data;
        this.filteredItemList = this.itemList;
      }
    );
  }

  search() {
    this.filteredItemList = this.itemList.filter(item => item.name.toLocaleLowerCase().includes(this.searchKey.toLocaleLowerCase()))
    this._product.getSubject().next(this.filteredItemList);
  }


  sortFunction() {
    if (this.sortKey == "name") {
      this.filteredItemList = this.filteredItemList.sort((a: Product, b: Product): number => {
        if (a.name > b.name)
          return 1;
        else
          return -1;
      })
    }

    if (this.sortKey == "stock") {
      this.filteredItemList = this.filteredItemList.sort((a: Product, b: Product): number => {
        if (a.stock_count > b.stock_count)
          return 1;
        else
          return -1;
      })
    }

    if (this.sortKey == "price") {
      this.filteredItemList = this.filteredItemList.sort((a: Product, b: Product): number => {
        if (a.rate_per_quantity > b.rate_per_quantity)
          return 1;
        else
          return -1;
      })
    }
  }
}
