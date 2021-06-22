import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IUser } from './interfaces/user.interface';
import { AuthenticationService } from './services/authentication.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'king';


  user!:IUser;

  constructor(
    private router:Router,
    private authenticationServics: AuthenticationService
  ){
    this.authenticationServics.user.subscribe(x => this.user = x)
  }


  logout(){
    this.authenticationServics.logout();
  }


}
