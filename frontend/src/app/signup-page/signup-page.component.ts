import { Component, OnInit } from '@angular/core';
import { IUser } from '../interfaces/user.interface';
import { UserService } from '../services/user.service';

interface Universidad {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css'],
})
export class SignupPageComponent implements OnInit {
  universidades: Universidad[] = [
    { value: 'UPC', viewValue: 'Univ. Peruana de Ciencias Aplicadas' },
    { value: 'PUCP', viewValue: 'Pontificia Universidad Catolica del Peru' },
    { value: 'UL', viewValue: 'Univ. de Lima' },
    { value: 'UCH', viewValue: 'Univ. Cayetano Heredia' },
  ];

  user?: IUser;

  constructor(private userService: UserService) {}

  ngOnInit(): void {}

  getUser(e: any): void {
    e.preventDefault();
    this.userService.getUser(1).subscribe((user) => (this.user = user.data));
  }
}
