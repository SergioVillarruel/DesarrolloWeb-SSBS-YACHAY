import { Component, Input, OnInit } from '@angular/core';
import { User } from '../User/user';
import { IUser } from '../interfaces/user.interface';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {
  
  user: IUser = {
     id : 4,
     nombre : "Pedro Pepe Sanchez",
     fecha_de_nacimiento : new Date(),
     genero : "Hombre",
     rol : "Estudiante",
     universidad : "UPC",
     imagen : "",
     correo : "pepe@gmail.com",
     password : "123",

  }

 


  constructor() { 
    
    

  }

  ngOnInit(): void {
  }

  capturarFile() {}





}
