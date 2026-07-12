package com.devhub.backend.modules.module.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ModuleDownloadServiceImpl implements ModuleDownloadService {

    private static final String AUTH_BACKEND =
            "downloads/authentication/devhub-auth-backend-v1.0.zip";

    private static final String AUTH_FRONTEND =
            "downloads/authentication/devhub-auth-frontend-v1.0.zip";

    private static final String AUTH_FULLSTACK =
            "downloads/authentication/fullstack.zip";

    @Override
    public Resource downloadAuthenticationBackend() {
        return new ClassPathResource(AUTH_BACKEND);
    }

    @Override
    public Resource downloadAuthenticationFrontend() {
        return new ClassPathResource(AUTH_FRONTEND);
    }

    @Override
    public Resource downloadAuthenticationFullStack() {
        return new ClassPathResource(AUTH_FULLSTACK);
    }
}