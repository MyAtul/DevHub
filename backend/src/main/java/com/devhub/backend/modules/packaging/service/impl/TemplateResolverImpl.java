package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.config.TemplateProperties;
import com.devhub.backend.modules.packaging.exception.PackageGenerationException;
import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.service.TemplateResolver;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TemplateResolverImpl implements TemplateResolver {

    private final TemplateProperties templateProperties;

    public TemplateResolverImpl(TemplateProperties templateProperties) {
        this.templateProperties = templateProperties;
    }

    @Override
    public Path resolveTemplate(PackageContext context) {

        Path templatePath = Paths.get(
                templateProperties.getPath(),
                context.getModuleName().toLowerCase(),
                context.getPackageType().name().toLowerCase()
        ).normalize();

        if (!Files.exists(templatePath)) {
            throw new PackageGenerationException(
                    "Template not found: " + templatePath
            );
        }

        if (!Files.isDirectory(templatePath)) {
            throw new PackageGenerationException(
                    "Template is not a directory: " + templatePath
            );
        }

        context.setTemplatePath(templatePath);

        return templatePath;
    }

}