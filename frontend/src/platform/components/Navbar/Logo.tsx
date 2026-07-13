import { Link } from "react-router-dom";

export default function Logo() {
    return (
        <Link
            to="/"
            className="text-4xl font-extrabold tracking-tight text-white transition hover:scale-105"
        >
            Dev<span className="text-blue-500">Hub</span>
        </Link>
    );
}