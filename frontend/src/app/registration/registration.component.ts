import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { User } from '../model/User';
import { UserService } from '../services/user.service';
import { AuthenticationService } from '../services/authentication.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  signUpForm: FormGroup;
  userType: string;
  user: User;
  userCreated: boolean = null;
  error: string;
  roles: any = [{ id: "A", name: "Shop Manager" }, { id: "C", name: "Customer" }];
  constructor(private formBuilder: FormBuilder, private _userService: UserService, private _product: ProductService) { }

  ngOnInit() {
    if (this._product.isAdmin)
      this.userType = "A";
    else
      this.userType = "U";
    this.signUpForm = this.formBuilder.group({
      username: ['', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50),
        this.isUsernameTaken
      ]],
      firstname: ['', [
        Validators.required,
        Validators.maxLength(50),
      ]],
      lastname: ['', [
        Validators.required,
        Validators.maxLength(50),
      ]],
      password: ['', [
        Validators.required,
        Validators.maxLength(50),
      ]],
      confirmPassword: ['', [
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
      age: ['', [
        Validators.required,
        Validators.maxLength(2),
      ]],
      contact: ['', [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
      ]],
      gender: ['', [
        Validators.required,
      ]],
      role: ['', [
        Validators.required,
      ]],
      question1: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],
      question3: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],
      question2: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],
      answer1: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],
      answer2: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],
      answer3: ['', [
        Validators.maxLength(50),
        Validators.required,
      ]],

    })
  }
  get username() {
    return this.signUpForm.get('username');
  }
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }
  get question1() {
    return this.signUpForm.get('question1');
  }
  get question2() {
    return this.signUpForm.get('question2');
  }
  get question3() {
    return this.signUpForm.get('question3');
  }
  get answer1() {
    return this.signUpForm.get('answer1');
  }
  get answer2() {
    return this.signUpForm.get('answer2');
  }
  get answer3() {
    return this.signUpForm.get('answer3');
  }
  get age() {
    return this.signUpForm.get('age');
  }
  get gender() {
    return this.signUpForm.get('gender');
  }
  get contact() {
    return this.signUpForm.get('contact');
  }
  get role() {
    return this.signUpForm.get('role');
  }
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
    if (formControl.value === 'admin') {
      return { 'userNameTaken': true };
    } else {
      return null;
    }


  }

  addUser() {
    console.log(this.signUpForm.value['firstname']);
    let tmpRole: string, tmpStatus: string;
    if (this.signUpForm.value['role'] == "Customer") {
      tmpRole = "U";
      tmpStatus = "A";
    }
    else {
      tmpRole = "A";
      tmpStatus = "P";
    }
    this.user = {
      id: null,
      firstname: this.signUpForm.value['firstname'],
      lastname: this.signUpForm.value['lastname'],
      password: this.signUpForm.value['password'],
      username: this.signUpForm.value['username'],
      age: this.signUpForm.value['age'],
      question1: this.signUpForm.value['question1'],
      question2: this.signUpForm.value['question2'],
      question3: this.signUpForm.value['question3'],
      answer1: this.signUpForm.value['answer1'],
      answer2: this.signUpForm.value['answer2'],
      answer3: this.signUpForm.value['answer3'],
      status: tmpStatus,
      contact: this.signUpForm.value['contact'],
      role: tmpRole,
      gender: this.signUpForm.value['gender']
    };
    this._userService.addUser(this.user).subscribe(data => {
      this.userCreated = true;
      this.error = "Signed Up Successfull.Go to Login Page"
      console.log(this.userCreated)
    },
      error => {
        console.log("error")
        console.log(error);
        if (error.status == 500 || error.status == 400) {
          this.error = error.message;
          this.userCreated = false;
        }
        console.log(this.error);
      }
    );
  }
}

