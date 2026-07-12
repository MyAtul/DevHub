import type { User } from "./user.type";

export interface RegisterRequest{
    firstName:string;
    lastName:string;
    username:string;
    email:string;
    password:string;
}

export interface LoginRequest{
    email:string;
    password:string;
}

export interface RefreshRequest{
    refreshToken:string;
}

export interface RegisterResponse extends User{
    message:string;
}

export interface LoginResponse extends User {
  accessToken: string;
  refreshToken: string;
  tokenType: "Bearer";
  expiresIn: number;
  message: string;
}

export interface RefreshResponse extends User {
  accessToken: string;
  refreshToken: string | null;
  tokenType: "Bearer";
  expiresIn: number;
  message: string;
}