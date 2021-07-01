import { Component, OnInit } from '@angular/core';
import { IUser } from '../interfaces/user.interface';
import {
  CourseService,
  CreateCourse,
  CreateCourseUser,
} from '../services/course.service';
import { Universidad } from '../signup-page/signup-page.component';

@Component({
  selector: 'app-new-course',
  templateUrl: './new-course.component.html',
  styleUrls: ['./new-course.component.css'],
})
export class NewCourseComponent implements OnInit {
  user: IUser = history.state.user;
  course: string = '';
  cicle: number = 1;
  uniSelected: string = '';

  universidades: Universidad[] = [
    { value: 'UPC', viewValue: 'Univ. Peruana de Ciencias Aplicadas' },
    { value: 'PUCP', viewValue: 'Pontificia Universidad Catolica del Peru' },
    { value: 'UL', viewValue: 'Univ. de Lima' },
    { value: 'UCH', viewValue: 'Univ. Cayetano Heredia' },
  ];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {}

  newCourse(e: any): void {
    e.preventDefault();
    const createCourse: CreateCourse = {
      nombre: this.course,
      ciclo: this.cicle,
      universidad: this.uniSelected,
    };
    this.courseService.createCourse(createCourse).subscribe((res) => {
      console.log(res);
      if (res.status === 'Success') {
        alert('Se ha agregado el curso');
      }
    });
  }
}
