package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.service.WorkspaceService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class WorkspaceServiceImpl  implements WorkspaceService {
    @Override
    public Path createWorkspace(Path templatePath) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
