import { Component, OnInit } from '@angular/core';
import { User } from '../User/user';
import { IUser } from '../interfaces/user.interface';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  
  constructor() { }

  ngOnInit(): void {
  }
  capturarFile(event: any) {
    
  }
}
