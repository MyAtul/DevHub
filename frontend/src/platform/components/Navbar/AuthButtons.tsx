import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../../modules/auth/hooks/useAuth";

export default function AuthButtons(){
    
    const {session} = useAuth()

    const {logout} = useAuth()

    const navigate = useNavigate()

    const handleLogout = async () =>{
        await logout()
        navigate("/")
    }

    if(!session.isAuthenticated){
        return(
            <div className="flex items-center gap-4">

                <Link
                    to="/login"
                    className="rounded-lg px-4 py-2 text-gray-300 transition hover:bg-gray-800 hover:text-white"
                >
                    Login
                </Link>

                <Link
                    to="/register"
                    className="rounded-xl bg-white px-5 py-2 font-medium text-black transition-all duration-200 hover:scale-105 hover:bg-gray-100"
                >
                    Register
                </Link>

            </div>
        )
    }

    return (
        <div className="flex items-center gap-4">

            <Link
                to="/dashboard"
                className="rounded-lg px-4 py-2 text-gray-300 transition hover:bg-gray-800 hover:text-white"
            >
                Dashboard
            </Link>

            <button
                onClick={handleLogout}
                className="cursor-pointer rounded-lg bg-red-600 px-4 py-2 font-medium text-white transition hover:bg-red-500"
            >
                Logout
            </button>

        </div>
        
    );
    
}