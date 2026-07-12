export const AUTH_CONFIG = {
    STORAGE_KEYS:{
        ACCESS_TOKEN: "devhub_access_token",
        REFRESH_TOKEN: "devhub_refresh_token",
        USER: "devhub_user",
    },

    ROUTES:{
        LOGIN: "/login",
        REGISTER: "/register",
        DASHBOARD: "/dashboard",
    },

} as const