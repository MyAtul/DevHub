import type { User } from "../config/user.type";


export interface AuthSession {
  user: User | null;
  accessToken: string | null;
  isAuthenticated: boolean;
}