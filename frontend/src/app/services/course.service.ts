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

export interface CreateCourseUser {
  experiencia: number;
  usuarioId: number;
  cursoId: number;
}

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  findCourse(course: string): Observable<any> {
    return this.http
      .get<any>(`${environment.apiUrl}/curso/${course}`)
      .pipe(catchError((e) => throwError(e)));
  }

  createCourse(createCourse: CreateCourse): Observable<any> {
    return this.http
      .post<any>(`${environment.apiUrl}/curso/newcurso`, createCourse)
      .pipe(catchError((e) => throwError(e)));
  }

  createCourseUser(createCourseUser: CreateCourseUser): Observable<any> {
    return this.http
      .post<any>(
        `${environment.apiUrl}/cursousuario/newcursousuario`,
        createCourseUser
      )
      .pipe(catchError((e) => throwError(e)));
  }
}
