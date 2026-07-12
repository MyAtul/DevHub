import { useLocation, useNavigate } from "react-router-dom";
import useAuth from "../../../modules/auth/hooks/useAuth";
import moduleDownloadService from "../../services/moduleDownloadService";

type DownloadCardProps = {
  title: string;
  description: string;
  downloadType: "backend" | "frontend" | "full";
};

export default function DownloadCard({
  title,
  description,
  downloadType,
}: DownloadCardProps) {

  const { session } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();

  const handleDownload = async () => {

      if (!session.isAuthenticated) {

          navigate("/login", {
              state: {
                  from: location.pathname,
              },
          });

          return;
      }

      try {

          switch (downloadType) {

              case "backend":
                  await moduleDownloadService.downloadBackend();
                  break;

              case "frontend":
                  await moduleDownloadService.downloadFrontend();
                  break;

              case "full":
                  await moduleDownloadService.downloadFullStack();
                  break;

          }

      } catch (error) {

          console.error(error);
          alert("Download failed.");

      }

  };

  return (
    <div className="rounded-xl border border-gray-800 p-6">

      <h3 className="text-xl font-semibold">
        {title}
      </h3>

      <p className="mt-3 text-gray-400">
        {description}
      </p>

      <button
        onClick={handleDownload}
        className="mt-6 rounded-lg bg-white px-5 py-3 text-black hover:bg-gray-200 cursor-pointer"
      >
        Download
      </button>

    </div>
  );
}