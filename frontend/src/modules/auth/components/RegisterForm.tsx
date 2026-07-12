import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../hooks/useAuth";

export default function RegisterForm() {
  const { register, loading } = useAuth();
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(
    e: React.FormEvent<HTMLFormElement>
  ) {
    e.preventDefault();

    await register({
      firstName,
      lastName,
      username,
      email,
      password,
    });

    navigate("/login", {
      state: {
        message: "Registration successful. Please login.",
      },
      replace: true,
    });
  }

  return (
    <form
      onSubmit={handleSubmit}
      className="w-full rounded-xl border border-gray-800 p-8"
    >
      <h1 className="mb-6 text-3xl font-bold">
        Register
      </h1>

      {/* We'll add all five input fields next */}
      <div className="mb-4">
        <label>First Name</label>

        <input
            type="text"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
            required
        />
      </div>

      <div className="mb-4">
        <label>Last Name</label>

        <input
            type="text"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
            required
        />
        </div>

        <div className="mb-4">
        <label>Username</label>

        <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
            required
        />
        </div>

        <div className="mb-4">
        <label>Email</label>

        <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
            required
        />
        </div>

        <div className="mb-6">
        <label>Password</label>

        <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="mt-2 w-full rounded border border-gray-700 bg-transparent p-3"
            required
        />
        </div>

      <button
        type="submit"
        disabled={loading}
        className="w-full rounded-lg bg-white py-3 text-black"
      >
        {loading ? "Registering..." : "Register"}
      </button>

      <p className="mt-6 text-center text-gray-400">
        Already have an account?{" "}
        <Link
          to="/login"
          className="text-blue-400 hover:underline"
        >
          Login
        </Link>
      </p>
    </form>
  );
}