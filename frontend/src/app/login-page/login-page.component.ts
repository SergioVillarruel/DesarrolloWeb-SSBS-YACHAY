import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService, LoginUsuario } from '../services/authentication.service';
/*import { UsersService } from '../user/user.service';*/

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit {

  user  : LoginUsuario = {correo: '', contraseña: ''}
  password = ''
  //----
  loginForm!: FormGroup;
  loading = false;
  submitted = false;
  returnUrl!: string;
  error = ''; 

  //---

  constructor(
    
    private authenticationService: AuthenticationService) { }

  ngOnInit(){
  
  }

  login(e :any){
    
    e.preventDefault();
      this.user.contraseña = this.password 
      this.authenticationService.login(this.user).subscribe((res) => console.log(res))
  
  }
}


// editar perfil para que agrege imagen.