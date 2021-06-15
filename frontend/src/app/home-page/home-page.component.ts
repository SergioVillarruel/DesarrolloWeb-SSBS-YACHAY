import { Component, OnInit } from '@angular/core';
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

  constructor(private tutorService: TutorService) {}

  ngOnInit(): void {}

  searchTutor(e: any): void {
    e.preventDefault();
    this.tutorService
      .getTutorsByCourse(this.course)
      .subscribe((res) => (this.tutors = res.data));
    console.log(this.tutors);
  }
}
