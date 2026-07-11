import { Link } from "react-router-dom";

export default function AuthButtons(){
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