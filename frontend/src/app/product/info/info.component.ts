import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/services/product.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  @Input() product: Product;
  @Output() deleteRequested = new EventEmitter();
  @Output() addToBillRequested = new EventEmitter<{ code: string, quantity: number }>();
  isAdmin: boolean;
  favoritesAddedId: number;
  Form: FormGroup;
  quantity: number = 0;

  constructor(private _product: ProductService, private formBuilder: FormBuilder) { }



  ngOnInit() {
    this.Form = this.formBuilder.group({
      qty: ['', [
        Validators.required,
      ]]
    })
  }

  edit() {
    this._product.editClicked = true;
  }

  get qty() {
    return this.Form.get('qty');
  }

  updateQty(code) {
    this.quantity = this.Form.value['qty'];
    this.addToBillRequested.emit({ code, quantity: this.quantity });
    console.log(this.quantity);
  }
}
