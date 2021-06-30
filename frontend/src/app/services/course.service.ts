import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

export interface CreateCourse {
  nombre: string;
  universidad: string;
  ciclo: number;
}

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  createCourse(createCourse: CreateCourse): Observable<any> {
    return this.http
      .post<any>(`${environment.apiUrl}/curso/newcurso`, createCourse)
      .pipe(catchError((e) => throwError(e)));
  }
}
