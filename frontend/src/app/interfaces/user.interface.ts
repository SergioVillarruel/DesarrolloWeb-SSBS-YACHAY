export interface IUser {
  id?: number;
  nombre: string;
  fecha_de_nacimiento?: Date;
  rol?: string;
  correo: string;
  contraseña?: string;
  universidad?: string;
  imagen?: string;
  portafolio?: string;
  tarifa?: number;
  genero?: string;
}

export interface UserResponse {
  code: string;
  message: string;
  status: string;
  data: IUser;
}

export interface TutorsResponse {
  code: string;
  message: string;
  status: string;
  data: IUser[];
}
