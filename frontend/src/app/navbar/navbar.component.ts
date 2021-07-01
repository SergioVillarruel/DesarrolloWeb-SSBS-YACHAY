import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IUser } from '../interfaces/user.interface';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor(private router: Router) {}

  @Input() user: IUser;

  ngOnInit(): void {}

  goProfUrl(rlink: string = ''): void {
    this.router.navigate([`${rlink}`]);
  }
  goToHome(): void {
    this.router.navigate(['home']);
  }
  goToCreateCouse(): void {
    this.router.navigateByUrl('/new-course', {
      state: {
        user: this.user,
      },
    });
  }
  gotToAddCourse(): void {
    this.router.navigateByUrl('/add-course', {
      state: {
        user: this.user,
      },
    });
  }
}
