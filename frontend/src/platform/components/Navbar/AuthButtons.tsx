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
            <div className="flex items-center gap-3">

                
            <Link
                to="/login"
                className="text-gray-300 hover:text-white"
            >
                Login
            </Link>

            <Link
                to="/register"
                className="rounded-lg bg-white hover:bg-gray-200 text-black px-4 py-2"
            >
                Register
            </Link>
        </div>
        )
    }

    return (
        <div className="flex gap-3">
            <Link
                to="/dashboard"
                className="text-gray-300 hover:text-white"
            >
                Dashboard
            </Link>

            <button
                onClick={handleLogout}
                className="text-gray-300 hover:text-white cursor-pointer bg-red-600 hover:bg-red-500 px-1 py-0.5 rounded"
            >
                Logout
        </button>

        </div>
        
    );
    
}