import { createContext, useEffect } from "react";
import type { LoginRequest, RegisterRequest } from "../config/auth.type";
import type { AuthSession } from "../types/auth-session.types";
import { useState, type ReactNode } from "react";
import authService from "../services/authService";
import tokenStorage from "../storage/tokenStorage";

const initialSession: AuthSession = {
  user: null,
  accessToken: null,
  isAuthenticated: false,
};


export interface AuthContextType {
    session: AuthSession;

    loading: boolean;

    initializing: boolean;

    login(request: LoginRequest): Promise<void>;

    register(request: RegisterRequest): Promise<void>;

    logout(): Promise<void>;
}

export const AuthContext = createContext<AuthContextType | undefined>(
  undefined
);

type AuthProviderProps = {
  children: ReactNode;
};

export default function AuthProvider({
  children,
}: AuthProviderProps) {

    const [session, setSession] = useState(initialSession);
    const [loading, setLoading] = useState(false);
    const [initializing, setInitializing] = useState(true);

   async function login(request: LoginRequest): Promise<void> {
      try {
        setLoading(true);

        const response = await authService.login(request);

        tokenStorage.setAccessToken(response.accessToken);
        tokenStorage.setRefreshToken(response.refreshToken);

        const user = {
          id: response.id,
          username: response.username,
          email: response.email,
        };

        tokenStorage.setUser(user);

        setSession({
          user,
          accessToken: response.accessToken,
          isAuthenticated: true,
        });

      } finally {
        setLoading(false);
      }
    }

    useEffect(() => {

      console.log("Restoring...")

        const accessToken = tokenStorage.getAccessToken();
        const user = tokenStorage.getUser();

        if (accessToken && user) {

          console.log("Toekn and user present")
            setSession({
                user,
                accessToken,
                isAuthenticated: true,
            });

            console.log("restoration done")

        }

        console.log("outside the if")


        setInitializing(false);

    }, []);

    async function register(request: RegisterRequest): Promise<void> {
      try {
        setLoading(true);

        await authService.register(request);

      } finally {
        setLoading(false);
      }
    }

    async function logout(): Promise<void> {
        tokenStorage.clearAuthStorage();

        setSession(initialSession);
    }

  return (
    <AuthContext.Provider
      value={{
      session,
      loading,
      initializing,
      login,
      register,
      logout,
}}
    >
      {children}
    </AuthContext.Provider>
  );
}

