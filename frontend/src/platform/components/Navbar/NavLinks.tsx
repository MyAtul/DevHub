import { NavLink } from "react-router-dom";
import { NAV_LINKS } from "../../constants/navigation";

export default function NavLinks() {

    return (

        <nav className="flex items-center gap-8">

            {NAV_LINKS.map((link) =>

                link.disabled ? (

                    <span
                        key={link.label}
                        className="cursor-not-allowed rounded-lg bg-gray-800 px-4 py-2 text-gray-500"
                    >
                        {link.label}
                    </span>

                ) : (

                    <NavLink
                        key={link.label}
                        to={link.path}
                        className={({ isActive }) =>
                            `border-b-2 px-1 py-2 transition-all duration-200 ${
                                isActive
                                    ? "border-blue-500 text-white"
                                    : "border-transparent text-gray-400 hover:border-gray-600 hover:text-white"
                            }`
                        }
                    >
                        {link.label}
                    </NavLink>

                )

            )}

        </nav>

    );
}