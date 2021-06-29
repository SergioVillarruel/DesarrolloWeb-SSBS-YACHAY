import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { IUser, UserResponse } from '../interfaces/user.interface';
import { User } from '../User/user';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http:HttpClient) { }

  postFile(filetoUpload:string, id:number): Observable<IUser>{
    
    return this.http
    .post<IUser>(`${environment.apiUrl}usuarios/editImagen/${id}`, filetoUpload)
    .pipe(catchError((e) =>throwError(e)));
  }

}
