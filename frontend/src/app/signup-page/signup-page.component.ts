import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IUser } from '../interfaces/user.interface';
import { UserService } from '../services/user.service';

export interface Universidad {
  value: string;
  viewValue: string;
}

interface Sexo {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css'],
})
export class SignupPageComponent implements OnInit {
  uniSelected: string = '';
  sexSelected: string = '';
  rolSelected: string = '';
  password: string = '';
  universidades: Universidad[] = [
    { value: 'UPC', viewValue: 'Univ. Peruana de Ciencias Aplicadas' },
    { value: 'PUCP', viewValue: 'Pontificia Universidad Catolica del Peru' },
    { value: 'UL', viewValue: 'Univ. de Lima' },
    { value: 'UCH', viewValue: 'Univ. Cayetano Heredia' },
  ];

  sexos: Sexo[] = [
    { value: 'masculino', viewValue: 'Masculino' },
    { value: 'femenino', viewValue: 'Femenino' },
  ];

  user: IUser = {
    nombre: '',
    correo: '',
    fecha_de_nacimiento: new Date(),
  };

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}

  registerUser(e: any): void {
    e.preventDefault();
    this.user.universidad = this.uniSelected;
    this.user.genero = this.sexSelected;
    this.user.rol = this.rolSelected;
    this.user.password = this.password;
    this.userService.createUser(this.user).subscribe((res) => {
      console.log(res);
      this.user = res.data;
      this.router.navigateByUrl('/home', { state: this.user });
    });
  }
}
