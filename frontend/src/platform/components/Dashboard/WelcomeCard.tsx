import useAuth from "../../../modules/auth/hooks/useAuth";

export default function WelcomeCard() {

    const { session } = useAuth();

    return (
        <div className="rounded-xl border border-gray-800 p-8">

            <h1 className="text-4xl font-bold">
                Welcome back, {session.user?.username}
            </h1>

            <p className="mt-3 text-gray-400">
                Build faster with reusable production-ready software modules.
            </p>

        </div>
    );
}