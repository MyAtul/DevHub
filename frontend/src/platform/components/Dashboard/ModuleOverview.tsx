import ModuleCard from "../Modules/ModuleCard";

export default function ModuleOverview() {

    return (

        <section>

            <h2 className="mb-6 text-2xl font-semibold">
                Available Modules
            </h2>

            <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">

                <ModuleCard
                    title="Authentication"
                    description="JWT Authentication for Spring Boot + React"
                    path="/modules/authentication"
                    available
                />

                <ModuleCard
                    title="Storage"
                    description="Coming Soon"
                />

                <ModuleCard
                    title="Notification"
                    description="Coming Soon"
                />

            </div>

        </section>

    );

}