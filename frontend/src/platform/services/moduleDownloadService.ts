import api from "../../modules/auth/services/api";
import tokenStorage from "../../modules/auth/storage/tokenStorage";

class ModuleDownloadService {

    private async download(
        url: string,
        filename: string
    ): Promise<void> {

        const accessToken = tokenStorage.getAccessToken();

        const response = await api.get(url, {
            responseType: "blob",
            headers: {
                Authorization: `Bearer ${accessToken}`,
            },
        });

        const blob = new Blob([response.data]);

        const downloadUrl = window.URL.createObjectURL(blob);

        const link = document.createElement("a");

        link.href = downloadUrl;
        link.download = filename;

        document.body.appendChild(link);

        link.click();

        document.body.removeChild(link);

        window.URL.revokeObjectURL(downloadUrl);
    }

    async downloadBackend(): Promise<void> {
        await this.download(
            "/modules/authentication/download/backend",
            "devhub-auth-backend-v1.0.zip"
        );
    }

    async downloadFrontend(): Promise<void> {
        await this.download(
            "/modules/authentication/download/frontend",
            "devhub-auth-frontend-v1.0.zip"
        );
    }

    async downloadFullStack(): Promise<void> {
        await this.download(
            "/modules/authentication/download/full",
            "devhub-auth-fullstack-v1.0.zip"
        );
    }
}

export default new ModuleDownloadService();