package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import com.devhub.backend.modules.packaging.exception.PackageGenerationException;
import com.devhub.backend.modules.packaging.mapper.PackageContextMapper;
import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.service.PackageGenerationService;
import com.devhub.backend.modules.packaging.service.TemplateResolver;
import com.devhub.backend.modules.packaging.service.TemplateTransformer;
import com.devhub.backend.modules.packaging.service.WorkspaceService;
import com.devhub.backend.modules.packaging.service.ZipService;
import com.devhub.backend.modules.packaging.util.FileSystemUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PackageGenerationServiceImpl implements PackageGenerationService {

    private final PackageContextMapper packageContextMapper;
    private final TemplateResolver templateResolver;
    private final WorkspaceService workspaceService;
    private final TemplateTransformer templateTransformer;
    private final ZipService zipService;

    public PackageGenerationServiceImpl(
            PackageContextMapper packageContextMapper,
            TemplateResolver templateResolver,
            WorkspaceService workspaceService,
            TemplateTransformer templateTransformer,
            ZipService zipService) {

        this.packageContextMapper = packageContextMapper;
        this.templateResolver = templateResolver;
        this.workspaceService = workspaceService;
        this.templateTransformer = templateTransformer;
        this.zipService = zipService;
    }

    @Override
    public byte[] generatePackage(PackageRequest request) {

        Path workspace = null;
        Path zipFile = null;

        try {

            PackageContext context = packageContextMapper.toContext(request);

            Path template = templateResolver.resolveTemplate(context);
            context.setTemplatePath(template);

            workspace = workspaceService.createWorkspace(context);
            context.setWorkspacePath(workspace);

            templateTransformer.transform(context);

            zipFile = zipService.createZip(workspace);

            return Files.readAllBytes(zipFile);

        } catch (IOException exception) {

            throw new PackageGenerationException(
                    "Failed to generate package.",
                    exception
            );

        } finally {

            if (workspace != null) {
                FileSystemUtils.deleteDirectory(workspace);
            }

            if (zipFile != null) {
                try {
                    Files.deleteIfExists(zipFile);
                } catch (IOException ignored) {

                }
            }
        }
    }
}