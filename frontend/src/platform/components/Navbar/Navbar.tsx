import AuthButtons from "./AuthButtons";
import Logo from "./Logo";
import NavLinks from "./NavLinks";

export default function Navbar() {
    return (
        <header className="sticky top-0 z-50 border-b border-gray-800 bg-black/90 backdrop-blur-md">
            <div className="mx-auto flex h-20 max-w-7xl items-center justify-between px-8">

                <Logo />

                <NavLinks />

                <AuthButtons />

            </div>
        </header>
    );
}