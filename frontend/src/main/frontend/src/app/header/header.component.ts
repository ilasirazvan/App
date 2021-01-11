import {Component, OnDestroy, OnInit} from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  public isUserLoggedIn = false;

  constructor(private loginService: AuthenticationService){ }
  ngOnInit() {
    this.isUserLoggedIn = this.loginService.isUserLoggedIn();
  }

  ngOnDestroy(): void {
    this.isUserLoggedIn = false;
  }

}
