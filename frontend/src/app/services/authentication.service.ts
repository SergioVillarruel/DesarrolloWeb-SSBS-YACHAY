import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { IUser, UserResponse } from '../interfaces/user.interface';


export interface LoginUsuario{
  correo : string;
  contraseña : string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private userSubject!: BehaviorSubject<IUser>;
  public user: Observable<IUser>;

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    this.userSubject = new BehaviorSubject<IUser>(JSON.parse(localStorage.getItem('User')!));
    this.user = this.userSubject.asObservable();
   }


   public get userValue(): IUser{
     return this.userSubject.value;
   }


   login(loginUsuario: LoginUsuario){
     return this.http.post<UserResponse>(`${environment.apiUrl}/usuarios/login`, loginUsuario)
     .pipe(catchError((e) => throwError(e)));
    
   }

   logout(){
     localStorage.removeItem('user');
     this.router.navigate(['/home'])
   }
}
