import { Component, OnInit } from '@angular/core';
import { User } from '../User/user';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  user:User={
    
    nombre: "Carlos",
    apellido: "Martin Sanchez",
    rol: "Maestro",
    edad: 15,
    universidad: "UPC",
    email:'pepe@gmail.com',
    password: '1234'
  };
  constructor() { }

  ngOnInit(): void {
  }

}
