export default function DownloadSection() {
    return (
        <section className="py-16">

            <h2 className="mb-8 text-3xl font-bold">
                Download Module
            </h2>

            <div className="flex flex-wrap gap-4">

                <button className="rounded-lg bg-white px-6 py-3 text-black">
                    Backend
                </button>

                <button className="rounded-lg bg-white px-6 py-3 text-black">
                    Frontend
                </button>

                <button className="rounded-lg bg-white px-6 py-3 text-black">
                    Full Module
                </button>

            </div>

        </section>
    );
}