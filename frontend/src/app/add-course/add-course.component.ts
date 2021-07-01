import { Component, OnInit } from '@angular/core';
import { IUser } from '../interfaces/user.interface';
import { CourseService, CreateCourseUser } from '../services/course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css'],
})
export class AddCourseComponent implements OnInit {
  user: IUser = history.state.user;
  exp: number = 100;
  course: string = '';
  courseId: number;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {}
  addCourse(e: any): void {
    e.preventDefault();
    this.courseService.findCourse(this.course).subscribe((res) => {
      console.log(res);
      if (res.status === 'Success') {
        const courseUser: CreateCourseUser = {
          experiencia: this.exp,
          usuarioId: this.user.id,
          cursoId: res.data.id,
        };
        this.courseService.createCourseUser(courseUser); //TODO subscribe
        alert(`${res.data.nombre} se ha agregado a tus cursos.`);
      }
    });
  }
}
