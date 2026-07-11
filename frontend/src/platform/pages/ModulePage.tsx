import ModuleCard from "../components/Modules/ModuleCard";


export default function ModulesPage() {
  return (
    <div className="mx-auto max-w-7xl py-20 px-6">

      <h1 className="mb-12 text-4xl font-bold">
        Modules
      </h1>

      <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">

        <ModuleCard
          title="Authentication"
          description="JWT Authentication for Spring Boot + React"
          path="/modules/authentication"
          available
        />

        <ModuleCard
          title="Storage"
          description="Cloud File Storage"
        />

        <ModuleCard
          title="Notification"
          description="Email & Push Notifications"
        />

        <ModuleCard
          title="Payments"
          description="Stripe Payment Integration"
        />

      </div>

    </div>
  );
}