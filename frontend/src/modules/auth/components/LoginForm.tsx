import { useState } from "react";
import useAuth from "../hooks/useAuth";
import { useLocation, useNavigate } from "react-router-dom";

export default function LoginForm() {
  const { login, loading } = useAuth();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate()
  const location = useLocation()

  async function handleSubmit(
    e: React.FormEvent<HTMLFormElement>
  ) {
    e.preventDefault();

    await login({
      email,
      password,
    });

    const from = location.state?.from || "/dashboard";

    navigate(from, {
      replace: true,
    });
  }

  return (
    <form
      onSubmit={handleSubmit}
      className="w-full rounded-xl border border-gray-800 p-8"
    >
      <h1 className="mb-6 text-3xl font-bold">
        Login
      </h1>

      <div className="mb-4">
        <label>Email</label>

        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
        />
      </div>

      <div className="mb-6">
        <label>Password</label>

        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
        />
      </div>

      <button
        type="submit"
        disabled={loading}
        className="w-full rounded-lg bg-white py-3 text-black"
      >
        {loading ? "Logging in..." : "Login"}
      </button>
    </form>
  );
}