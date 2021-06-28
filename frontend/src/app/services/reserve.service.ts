import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

interface Reservation {
  alumnoID?: number;
  tutorID?: number;
  fecha?: Date;
}

@Injectable({
  providedIn: 'root',
})
export class ReserveService {
  constructor(private http: HttpClient) {}

  makeReservation(reservation: Reservation): Observable<any> {
    return this.http
      .post<any>(`${environment.apiUrl}/reserva/crearReserva`, reservation)
      .pipe(catchError((e) => throwError(e)));
  }
}
