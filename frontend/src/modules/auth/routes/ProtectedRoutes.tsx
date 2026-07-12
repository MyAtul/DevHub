import { Navigate, Outlet } from "react-router-dom";
import useAuth from "../hooks/useAuth";

export default function ProtectedRoute() {
  const { session, initializing } = useAuth();

    if (initializing) {
        return <p>Loading...</p>;
    }

    if (!session.isAuthenticated) {
        return <Navigate to="/login" replace />;
    }

    return <Outlet />;
}