const technologies = [
    "Spring Boot",
    "Java",
    "React",
    "TypeScript",
    "PostgreSQL",
    "Docker",
    "JWT",
    "Maven"
];

export default function TechStack() {
    return (
        <section className="py-12">

            <h2 className="text-3xl font-bold mb-8">
                Tech Stack
            </h2>

            <div className="flex flex-wrap gap-4">

                {technologies.map((technology) => (
                    <div
                        key={technology}
                        className="rounded-lg border border-gray-800 px-4 py-2"
                    >
                        {technology}
                    </div>
                ))}

            </div>

        </section>
    );
}