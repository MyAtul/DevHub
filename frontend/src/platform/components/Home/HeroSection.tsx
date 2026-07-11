import { Link } from "react-router-dom";

export default function HeroSection() {
  return (
    <section className="flex flex-col items-center justify-center py-24 text-center">
      <p className="mb-4 rounded-full border border-gray-700 px-4 py-1 text-sm text-gray-400">
        Build Once. Reuse Everywhere.
      </p>

      <h1 className="max-w-4xl text-5xl font-bold leading-tight">
        Download Production Ready
        <br />
        Software Modules
      </h1>

      <p className="mt-6 max-w-2xl text-lg text-gray-400">
        DevHub helps developers accelerate development by providing reusable
        backend and frontend modules with documentation and architecture guides.
      </p>

      <div className="mt-10 flex gap-4">
        <Link
          to="/modules"
          className="rounded-lg bg-white px-6 py-3 text-black"
        >
          Explore Modules
        </Link>

        <button className="rounded-lg border border-gray-700 px-6 py-3">
          Documentation
        </button>
      </div>
    </section>
  );
}