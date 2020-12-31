import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/Product';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  itemForm: FormGroup = new FormGroup({});
  addDone: boolean = false;
  product: Product = {
    code: '',
    name: '',
    type: '',
    brand: '',
    quantity_type: '',
    rate_per_quantity: '',
    stock_count: '',
    add_date: new Date(),
    aisle: '',
    shelf: '',
    date_of_manufacture: new Date(),
    date_of_expiry: new Date(),
    image: '',
  };
  saved: boolean = false;
  editDone: boolean = false;
  id: string = null;
  constructor(private formBuild: FormBuilder, private _product: ProductService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    if (this._product.editClicked) {
      this.id = this.route.snapshot.paramMap.get('code');
      this._product.getProduct(this.id).subscribe(
        data => {
          console.log(data);
          this.product = data;
          console.log(this.product.name)
          this.itemForm = this.formBuild.group({
            Pname: [this.product.name, [
              Validators.required,
              Validators.minLength(2),
              Validators.maxLength(20)
            ]],
            image: [this.product.image, [
              Validators.required
            ]],
            aisle: [this.product.aisle, [
              Validators.required
            ]],
            dateOfMfg: [this.product.date_of_manufacture, [
              Validators.required
            ]],
            type: [this.product.type, [
              Validators.required
            ]],
            stock: [this.product.stock_count, [
              Validators.required
            ]],
            shelf: [this.product.shelf,
            Validators.required
            ],
            code: [{ value: this.product.code, disabled: true },
            ],
            rate: [this.product.rate_per_quantity,
            Validators.required
            ],
            addDate: [this.product.add_date,
            Validators.required
            ],
            brand: [this.product.brand,
            Validators.required
            ],
            qty: [this.product.quantity_type,
            Validators.required
            ],
            dateOfExp: [this.product.date_of_expiry, [
              Validators.required
            ]],
          })
        }
      )
    }
    else {
      this.itemForm = this.formBuild.group({
        Pname: [this.product.name, [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(20)
        ]],
        image: [this.product.image, [
          Validators.required
        ]],
        aisle: [this.product.aisle, [
          Validators.required
        ]],
        dateOfMfg: [this.product.date_of_manufacture.toISOString().substring(0, 10), [
          Validators.required
        ]],
        type: [this.product.type, [
          Validators.required
        ]],
        stock: [this.product.stock_count, [
          Validators.required
        ]],
        shelf: [this.product.shelf,
        Validators.required
        ],
        code: [this.product.code,
        Validators.required,
        ],
        rate: [this.product.rate_per_quantity,
        Validators.required
        ],
        addDate: [this.product.add_date,
        Validators.required
        ],
        brand: [this.product.brand,
        Validators.required
        ],
        qty: [this.product.quantity_type,
        Validators.required
        ],
        dateOfExp: [this.product.date_of_expiry.toISOString().substring(0, 10), [
          Validators.required
        ]],
      })
    }
  }
  get Pname() {
    return this.itemForm.get('Pname');
  }
  get image() {
    return this.itemForm.get('image');
  }
  get type() {
    return this.itemForm.get('type');
  }
  get dateOfMfg() {
    return this.itemForm.get('dateOfMfg');
  }
  get dateOfExp() {
    return this.itemForm.get('dateOfExp');
  }
  get code() {
    return this.itemForm.get('code');
  }
  get stock() {
    return this.itemForm.get('stock');
  }

  get addDate() {
    return this.itemForm.get('addDate');
  }
  get rate() {
    return this.itemForm.get('rate');
  }
  get qty() {
    return this.itemForm.get('qty');
  }
  get brand() {
    return this.itemForm.get('brand');
  }
  get aisle() {
    return this.itemForm.get('aisle');
  }
  get shelf() {
    return this.itemForm.get('shelf');
  }

  onSubmit() {

    if (!this._product.editClicked)
      this.product.code = this.itemForm.value['code']

    let newItem: Product = {
      code: this.product.code,
      name: this.itemForm.value['Pname'],
      shelf: this.itemForm.value['shelf'],
      aisle: this.itemForm.value['aisle'],
      date_of_manufacture: new Date(this.itemForm.value['dateOfMfg']),
      date_of_expiry: new Date(this.itemForm.value['dateOfExp']),
      stock_count: this.itemForm.value['stock'],
      quantity_type: this.itemForm.value['qty'],
      rate_per_quantity: this.itemForm.value['rate'],
      add_date: this.itemForm.value['addDate'],
      image: this.itemForm.value['image'],
      brand: this.itemForm.value['brand'],
      type: this.itemForm.value['type']
    }
    console.log(newItem);

    if (this._product.editClicked) {
      this._product.edit(newItem).subscribe();
      this.editDone = true;
      this._product.editClicked = false;
    }
    else {
      this._product.save(newItem).subscribe();
      this.addDone = true;
    }
  }
}
