package com.devhub.backend.modules.packaging.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;


public interface WorkspaceService {

    Path createWorkspace(Path templatePath);
}
