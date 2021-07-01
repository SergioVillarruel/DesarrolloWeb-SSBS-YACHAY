import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { TutorsResponse } from '../interfaces/user.interface';

@Injectable({
  providedIn: 'root',
})
export class TutorService {
  constructor(private http: HttpClient) {}

  getTutorsByCourse(
    filter: string,
    option: string
  ): Observable<TutorsResponse> {
    return this.http
      .get<TutorsResponse>(`${environment.apiUrl}/usuarios/${filter}/${option}`)
      .pipe(catchError((e) => throwError(e)));
  }
}
