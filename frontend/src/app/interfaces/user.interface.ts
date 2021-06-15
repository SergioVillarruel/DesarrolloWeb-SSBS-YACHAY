export interface IUser {
  id: number;
  nombre: string;
  fecha_de_nacimiento: Date;
  rol: string;
  correo: string;
  contraseña?: string;
  universidad: string;
  imagen: string;
  portafolio: string;
  genero: string;
}

export interface UserResponse {
  code: string;
  message: string;
  status: string;
  data: IUser;
}
