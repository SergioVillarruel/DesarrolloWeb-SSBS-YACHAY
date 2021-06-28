import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IUser } from '../interfaces/user.interface';
import { ReserveService } from '../services/reserve.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  reservationDate?: Date;
  hour?: number;
  user: IUser = history.state.currentUser;
  tutor: IUser = history.state.tutor;

  constructor(private reserveService: ReserveService, private router: Router) {}

  ngOnInit(): void {
    console.log(history.state);
  }

  reserve(): void {
    const reserve = {
      alumnoID: this.user.id,
      tutorID: this.tutor.id,
      fecha: this.reservationDate,
    };
    this.reserveService.makeReservation(reserve).subscribe((res) => {
      console.log(res);
      console.log('Gratz new reservation created');
      if (res.status == 'Success') {
        alert('Felicidades la reserva a sido creada');
      }
    });
  }
}
