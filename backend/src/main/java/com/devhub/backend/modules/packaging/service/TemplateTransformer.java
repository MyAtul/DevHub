package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.model.PackageContext;

import java.nio.file.Path;

public interface TemplateTransformer {

    void transform(Path workspace, PackageContext context);
}
