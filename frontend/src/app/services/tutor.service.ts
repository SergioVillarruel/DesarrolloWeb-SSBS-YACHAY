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

  getTutorsByCourse(course: string): Observable<TutorsResponse> {
    return this.http
      .get<TutorsResponse>(`${environment.apiUrl}/usuarios/rol/${course}`)
      .pipe(catchError((e) => throwError(e)));
  }
}
