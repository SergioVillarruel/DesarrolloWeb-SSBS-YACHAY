import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IUser } from '../interfaces/user.interface';
import { TutorService } from '../services/tutor.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent implements OnInit {
  course: string = '';
  tutors: IUser[] = [];
  user: IUser = history.state;

  constructor(private tutorService: TutorService, private router: Router) {}

  ngOnInit(): void {}

  searchTutor(e: any): void {
    e.preventDefault();
    this.tutorService
      .getTutorsByCourse(this.course)
      .subscribe((res) => (this.tutors = res.data));
    console.log(this.tutors);
  }

  reserva(e: any, tutor: IUser): void {
    e.preventDefault();
    console.log(tutor);
    this.router.navigateByUrl('/reservation', {
      state: {
        currentUser: this.user,
        tutor: tutor,
      },
    });
  }
}
