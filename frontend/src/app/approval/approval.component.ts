import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/User';

@Component({
  selector: 'app-approval',
  templateUrl: './approval.component.html',
  styleUrls: ['./approval.component.css']
})
export class ApprovalComponent implements OnInit {

  constructor(private _userService: UserService) { }
  list: User[];
  accepted: boolean;
  declined: boolean;

  ngOnInit() {
    this._userService.getPendingUsers().subscribe(
      data => {
        this.list = data;
        console.log(data);
      }
    )
  }

  updateStatus(user: User, status: string) {
    console.log("Inside update status");
    user.status = status;
    console.log(user);
    this._userService.updateStatus(user).subscribe(
      data => {
        this.list = data;
        console.log(data);
      }
    );
  }

}
