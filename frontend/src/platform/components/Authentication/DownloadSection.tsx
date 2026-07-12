import DownloadCard from "./DownloadCard";

export default function DownloadSection() {

  return (

    <section className="py-16">

      <h2 className="mb-10 text-3xl font-bold">
        Download Module
      </h2>

      <div className="grid gap-6 md:grid-cols-3">

        <DownloadCard
          title="Backend Module"
          description="Spring Boot, Spring Security, JWT Authentication"
          downloadType="backend"
        />

        <DownloadCard
          title="Frontend Module"
          description="React, TypeScript, Context API"
          downloadType="frontend"
        />

        <DownloadCard
          title="Full Stack Module"
          description="Backend + Frontend + Documentation"
          downloadType="full"
        />

      </div>

    </section>

  );
}