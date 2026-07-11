import { NavLink } from "react-router-dom";
import { NAV_LINKS } from "../../constants/navigation";

export default function NavLinks(){

    return(
        <nav className="flex items-center gap-4">
            {
                NAV_LINKS.map((link)=>
                    link.disabled ?(
                        <span
                            key={link.label}
                            className="bg-gray-500 cursor-not-allowed"
                        >
                            {link.label}
                        </span>
                    ):(
                        <NavLink
                            key={link.label}
                            to={link.path}
                            className="text-gray-300 hover:text-white transition-colors"
                        >
                            {link.label}
                        </NavLink>
                    )
                )
            }
        </nav>
    )
}
