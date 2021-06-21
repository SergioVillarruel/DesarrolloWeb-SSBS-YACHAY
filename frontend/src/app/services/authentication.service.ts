import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { IUser } from '../interfaces/user.interface';
import { User } from '../User/user';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private userSubject!: BehaviorSubject<User>;
  public user: Observable<User>;

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('User')!));
    this.user = this.userSubject.asObservable();
   }


   public get userValue(): User{
     return this.userSubject.value;
   }


   login(username: string, password: string){
     return this.http.post<any>(`${environment.apiUrl}usuarios/login`, {username, password}).pipe(map(user => {
       user.authdata = window.btoa(username+ ':'+ password);
       localStorage.setItem('user', JSON.stringify(user));
       this.userSubject.next(user);
       return user;
     }));
   }

   logout(){
     localStorage.removeItem('user');
     //this.userSubject.next(null);
     this.router.navigate(['/home'])
   }
}
