import { Link } from "react-router-dom";

export default function FeaturedModules() {
  return (
    <section className="py-20">
      <h2 className="mb-8 text-center text-3xl font-bold">
        Featured Modules
      </h2>

      <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-4">

        <Link
          to="/modules/authentication"
          className="rounded-xl border border-gray-800 p-6"
        >
          <h3 className="text-xl font-semibold">
            Authentication
          </h3>

          <p className="mt-2 text-gray-400">
            JWT Authentication Module
          </p>
        </Link>

        <div className="rounded-xl border border-gray-800 p-6 opacity-50">
          Storage
        </div>

        <div className="rounded-xl border border-gray-800 p-6 opacity-50">
          Notification
        </div>

        <div className="rounded-xl border border-gray-800 p-6 opacity-50">
          Payments
        </div>

      </div>
    </section>
  );
}