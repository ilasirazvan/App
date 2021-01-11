import { Component, OnInit } from '@angular/core';
import { HttpclientService, UserAccount} from '../service/httpclient.service';

@Component({
  selector: 'app-useraccount',
  templateUrl: './useraccount.component.html',
  styleUrls: ['./useraccount.component.css']
})
export class UseraccountComponent implements OnInit {

  useraccounts: UserAccount[];


  constructor(
    private httpClientService: HttpclientService
  ) { }

  ngOnInit() {
    this.httpClientService.getUsers().subscribe(
      response =>this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response)
  {
    this.useraccounts = response;
  }
}
