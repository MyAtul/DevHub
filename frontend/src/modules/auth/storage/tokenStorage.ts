import { AUTH_CONFIG } from "../config/auth.config";
import type { User } from "../config/user.type";

const ACCESS_TOKEN_KEY = AUTH_CONFIG.STORAGE_KEYS.ACCESS_TOKEN;
const REFRESH_TOKEN_KEY = AUTH_CONFIG.STORAGE_KEYS.REFRESH_TOKEN;
const USER_KEY = AUTH_CONFIG.STORAGE_KEYS.USER;

function setUser(user: User): void {
  localStorage.setItem(USER_KEY, JSON.stringify(user));
}

function setAccessToken(token: string): void {
  localStorage.setItem(ACCESS_TOKEN_KEY, token);
}

function getAccessToken(): string | null {
  return localStorage.getItem(ACCESS_TOKEN_KEY);
}

function removeAccessToken(): void {
  localStorage.removeItem(ACCESS_TOKEN_KEY);
}

function setRefreshToken(token: string): void {
  localStorage.setItem(REFRESH_TOKEN_KEY, token);
}

function getRefreshToken(): string | null {
  return localStorage.getItem(REFRESH_TOKEN_KEY);
}

function removeRefreshToken(): void {
  localStorage.removeItem(REFRESH_TOKEN_KEY);
}

function getUser(): User | null {
  const user = localStorage.getItem(USER_KEY);

  if (!user) {
    return null;
  }

  return JSON.parse(user) as User;
}

function removeUser(): void {
  localStorage.removeItem(USER_KEY);
}

function clearAuthStorage(): void {
  removeAccessToken();
  removeRefreshToken();
  removeUser();
}

const tokenStorage = {
  getAccessToken,
  setAccessToken,
  removeAccessToken,

  getRefreshToken,
  setRefreshToken,
  removeRefreshToken,

  getUser,
  setUser,
  removeUser,

  clearAuthStorage,
};

export default tokenStorage;