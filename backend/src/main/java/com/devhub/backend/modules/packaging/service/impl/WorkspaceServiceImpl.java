package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.exception.PackageGenerationException;
import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.service.WorkspaceService;
import com.devhub.backend.modules.packaging.util.FileSystemUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class WorkspaceServiceImpl  implements WorkspaceService {

    @Override
    public Path createWorkspace(PackageContext context) {

        try{
            Path workspace = Files.createTempDirectory("devhub-package-");

            FileSystemUtils.copyDirectory(
                    context.getTemplatePath(),
                    workspace
            );

            return workspace;

        }catch (IOException exception){
            throw new PackageGenerationException(
                    "Failed to create temporary workspace. ",
                    exception
            );
        }

    }
}
