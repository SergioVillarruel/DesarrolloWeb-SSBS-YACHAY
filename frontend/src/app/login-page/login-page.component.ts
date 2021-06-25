import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService, LoginUsuario } from '../services/authentication.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit {

  user  : LoginUsuario = {correo: 'asd@gmail.com', contraseña: '123'}
  password = '123'
  //----
 

  //---

  constructor(
    
    private authenticationService: AuthenticationService,
    private router: Router,

    ) { }

  ngOnInit(){
  
  }

  login(e :any){
    
    e.preventDefault();
      this.user.contraseña = this.password 
      this.authenticationService.login(this.user).subscribe((res) => console.log(res))

      if (this.authenticationService.user){
        this.router.navigate(['/home']);
      }
  }
}


// editar perfil para que agrege imagen.