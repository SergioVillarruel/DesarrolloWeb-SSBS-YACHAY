import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { IUser, UserResponse } from '../interfaces/user.interface';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUser(id: number): Observable<UserResponse> {
    return this.http
      .get<UserResponse>(`${environment.apiUrl}/usuarios/id/${id}`)
      .pipe(catchError((e) => throwError(e)));
  }

  createUser(user: IUser): Observable<IUser> {
    return this.http
      .post<IUser>(`${environment.apiUrl}/usuarios/register`, user)
      .pipe(catchError((e) => throwError(e)));
  }
}
