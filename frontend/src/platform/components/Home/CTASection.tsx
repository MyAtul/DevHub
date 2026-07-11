import { Link } from "react-router-dom";

export default function CTASection() {
  return (
    <section className="py-24 text-center">
      <h2 className="text-4xl font-bold">
        Start Building Faster
      </h2>

      <p className="mt-4 text-gray-400">
        Download reusable modules and integrate them into your projects.
      </p>

      <Link
        to="/modules"
        className="mt-8 inline-block rounded-lg bg-white px-6 py-3 text-black"
      >
        Browse Modules
      </Link>
    </section>
  );
}