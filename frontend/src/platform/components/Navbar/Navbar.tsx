import AuthButtons from "./AuthButtons";
import Logo from "./Logo";
import NavLinks from "./NavLinks";

export default function Navbar(){
    return(
        <header className="border-b border-gray-800 flex gap-4">
            <div className="flex justify-center items-center h-16 mx-auto max-w-7xl px-6">
                <Logo/>
                <NavLinks/>
                <AuthButtons/>
            </div>
        </header>
    )

}