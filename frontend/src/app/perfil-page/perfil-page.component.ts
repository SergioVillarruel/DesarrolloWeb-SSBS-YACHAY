import { Component, Input, OnInit } from '@angular/core';
import { User } from '../User/user';
import { IUser } from '../interfaces/user.interface';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UploadService } from '../services/upload.service';


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

  imageUrl : string = "/assets/img/default.png";
  selectedFile : File;



  constructor(private router:Router, private http:HttpClient, private uploadService:UploadService) { }

  ngOnInit(): void {
  }

  
  
  goBackUrl(rlink: string = '/home'): void{
    console.log("ENMTRAS");
    this.router.navigate([`${rlink}`]);
  }

  //--------------------a

  onFileSelected(event:any){
    this.selectedFile= event.target.files[0];
    var reader = new FileReader();
    reader.onload = (event: any) =>{
      this.imageUrl = event.target.result;
      this.user.imagen = this.imageUrl
      console.log(this.user)
    }
    reader.readAsDataURL(this.selectedFile)

  this.uploadService.postFile(this.imageUrl, this.user.id).subscribe(
    data =>{
      alert("successfully upload");
      this.imageUrl = "";
    }
  )
  }
    

  onSave(){
    undefined;
  }






  /*
  onSubmit(){
    this.uploadService.postFile( "hola", this.user).subscribe(
      data=>{
       this.user
      }
    )
  }
  */

}
