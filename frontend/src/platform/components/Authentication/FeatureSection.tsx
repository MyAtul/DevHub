const features = [
    "User Registration",
    "User Login",
    "JWT Authentication",
    "Refresh Token",
    "BCrypt Password Encryption",
    "Spring Security",
    "Protected Routes",
    "Global Exception Handling"
];

export default function FeatureSection() {
    return (
        <section className="py-12">

            <h2 className="text-3xl font-bold mb-8">
                Features
            </h2>

            <div className="grid gap-4 md:grid-cols-2">

                {features.map((feature) => (
                    <div
                        key={feature}
                        className="rounded-lg border border-gray-800 p-4"
                    >
                        ✔ {feature}
                    </div>
                ))}

            </div>

        </section>
    );
}