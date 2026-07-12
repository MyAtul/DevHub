import { Link } from "react-router-dom";

export default function QuickActions() {
    return (
        <section>

            <h2 className="mb-6 text-2xl font-semibold">
                Quick Actions
            </h2>

            <div className="flex gap-4">

                <Link
                    to="/modules"
                    className="rounded-lg bg-white px-5 py-3 text-black"
                >
                    Browse Modules
                </Link>

                <Link
                    to="/modules/authentication"
                    className="rounded-lg border border-gray-700 px-5 py-3"
                >
                    Authentication Module
                </Link>

            </div>

        </section>
    );
}