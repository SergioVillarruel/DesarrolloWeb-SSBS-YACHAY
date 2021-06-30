import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { NewCourseComponent } from './new-course/new-course.component';
import { PerfilPageComponent } from './perfil-page/perfil-page.component';
import { ReservationComponent } from './reservation/reservation.component';

import { SignupPageComponent } from './signup-page/signup-page.component';

const routes: Routes = [
  { path: 'signup', component: SignupPageComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'new-course', component: NewCourseComponent },

  { path: 'login', component: LoginPageComponent },
  { path: 'prof', component: PerfilPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
