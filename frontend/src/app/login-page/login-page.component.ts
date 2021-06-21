import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
/*import { UsersService } from '../user/user.service';*/

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit {

  //----
  loginForm!: FormGroup;
  loading = false;
  submitted = false;
  returnUrl!: string;
  error = ''; 

  //---

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) { 
    if(this.authenticationService.userValue){
      this.router.navigate(['/'])
    }

  }

  ngOnInit(){
    this.loginForm = this.formBuilder.group({
      correo: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.returnUrl = this.route.snapshot.queryParams['home'] || '/';
  }

  get f() { return this.loginForm!.controls;}



  onSubmit(){
    this.submitted = true;

    console.log(this.f.correo.value);
    console.log(this.f.password.value);
    
    if (this.loginForm!.invalid){ return;}

    this.loading = true;
    this.authenticationService.login(this.f.correo.value, this.f.password.value).pipe(first())
    .subscribe(data => {
      this.router.navigate([this.returnUrl]);

    },
    error =>{
      this.error = error;
      this.loading = false;
    });

  }
}
