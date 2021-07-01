import { Component, Input, OnInit } from '@angular/core';
import { User } from '../User/user';
import { IUser } from '../interfaces/user.interface';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UploadService } from '../services/upload.service';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  user: IUser = history.state.user;
  imageUrl : string = "/assets/img/default.png";
  selectedFile : File;



  constructor(private router:Router,
    private http:HttpClient,
    private uploadService:UploadService,
    private userService:UserService
    ) { }

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
    
    this.userService.editUser(this.user.id, this.user).subscribe((res) =>{
      console.log(res);
    })
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
