package com.devhub.backend.modules.module.service;

import org.springframework.core.io.Resource;

public interface ModuleDownloadService {

    Resource downloadAuthenticationBackend();

    Resource downloadAuthenticationFrontend();

    Resource downloadAuthenticationFullStack();

}