package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.model.PackageContext;

import java.nio.file.Path;


public interface WorkspaceService {

    Path createWorkspace(PackageContext context);
}
