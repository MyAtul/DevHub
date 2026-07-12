import { useLocation } from "react-router-dom";
import LoginForm from "../components/LoginForm";

export default function LoginPage() {

  const location = useLocation()
  return (
    <div className="mx-auto flex min-h-[80vh] max-w-md items-center justify-center px-6">
      {location.state?.message && (
        <div className="mb-4 rounded-lg border border-green-600 bg-green-950 p-3 text-green-300">
          {location.state.message}
        </div>
      )}
      <LoginForm />
    </div>
  );
}