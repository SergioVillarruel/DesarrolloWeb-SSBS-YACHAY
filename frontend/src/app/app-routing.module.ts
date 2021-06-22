import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { PerfilPageComponent } from './perfil-page/perfil-page.component';

import { SignupPageComponent } from './signup-page/signup-page.component';

const routes: Routes = [
  { path: 'signup', component: SignupPageComponent },
  { path: 'home', component: HomePageComponent },


  { path: 'login', component: LoginPageComponent},
  { path: 'prof', component: PerfilPageComponent},
  //{ path: '', component: HomePageComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
