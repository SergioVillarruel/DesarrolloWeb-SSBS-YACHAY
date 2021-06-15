import { Component } from '@angular/core';
/*import { UsersService } from '../user/user.service';*/

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  email: string = "";
  password: string = "";

  constructor() { }

  login(){
    console.log(this.email);
    console.log(this.password);
  }

  
}
