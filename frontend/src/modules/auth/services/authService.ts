import type { LoginRequest, LoginResponse, RefreshRequest, RefreshResponse, RegisterRequest, RegisterResponse } from "../config/auth.type";
import api from "./api";

class AuthService {

    async register(
        request:RegisterRequest
    ):Promise<RegisterResponse>{
        const response = await api.post<RegisterResponse>(
            "/auth/register",
            request
        )

        return response.data
    }

    async login(
        request:LoginRequest
    ):Promise<LoginResponse>{
        const response = await api.post<LoginResponse>(
            "/auth/login",
            request
        )
        return response.data
    }

    async refresh(
        request:RefreshRequest
    ):Promise<RefreshResponse>{
        const response = await api.post<RefreshResponse>(
            "/auth/refresh",
            request
        )
        return response.data
    }

    async logout(refreshToken:string):Promise<void>{
        await api.post("/auth/logout",{
            refreshToken
        })
    }

}

export default new AuthService()