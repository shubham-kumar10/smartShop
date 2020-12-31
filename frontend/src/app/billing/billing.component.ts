import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../model/Product';
import { Bill } from '../model/Bill';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  billDone: boolean = false;
  types = ["Food", "Beverages", "Snacks", "Cosmetics"];
  filterKey: string;
  itemList: Product[];
  filteredItemList: Product[];
  bill: Bill = { contact: "", productList: [], quantity: [], total: 0 }
  empty: boolean;
  Form: FormGroup = new FormGroup({});
  error: string;

  constructor(private _product: ProductService, private formBuild: FormBuilder) { }
  ngOnInit() {
    this._product.billing = true;
    console.log(this._product.billing);
    this._product.getAllProducts().subscribe(
      data => {
        this.itemList = data;
        this.filteredItemList = this.itemList;
      }
    )
    this.empty = true;
    this.billDone = false;
    this.Form = this.formBuild.group({
      phone: ['', [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10)
      ]]
    })
  }
  get phone() {
    return this.Form.get('phone');
  }
  searchByType() {
    this.filteredItemList = this.itemList.filter(item => item.type.toLocaleLowerCase().includes(this.filterKey.toLocaleLowerCase()))
    this._product.getSubject().next(this.filteredItemList);
  }

  searchByCode() {
    this.filteredItemList = this.itemList.filter(item => item.code.toLocaleLowerCase().includes(this.filterKey.toLocaleLowerCase()))
    this._product.getSubject().next(this.filteredItemList);
  }

  addToBill(details: { code: string, quantity: number }) {
    this.bill.contact = this.Form.value['phone']
    console.log(details.quantity);
    this._product.billing = true;
    this.empty = false;
    this._product.getProduct(details.code).subscribe(
      data => {
        this.bill.productList.push(data);
        this.bill.quantity.push(details.quantity);
        this.bill.total = this.bill.total + (details.quantity * +data.rate_per_quantity);
      }
    )
    console.log(this.bill);

  }

  onSubmit() {
    this.bill.contact = this.Form.value['phone'];
    if (this.bill.contact == "")
      this.error = "Enter Customer Phone Number"
    else {
      this.error = null;
      this._product.addBill(this.bill).subscribe(
        data => console.log(data),
        HttpError => this.error = HttpError
      );
      this.billDone = true;
      this.empty = true;
    }
  }

}
