package com.devhub.backend.modules.packaging.model;

import com.devhub.backend.modules.packaging.dto.PackageType;

import java.nio.file.Path;

public class PackageContext {

    private final String moduleName;

    private final PackageType packageType;

    private Path templatePath;

    private Path workspacePath;

    public PackageContext(String moduleName,
                          PackageType packageType) {
        this.moduleName = moduleName;
        this.packageType = packageType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public Path getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(Path templatePath) {
        this.templatePath = templatePath;
    }

    public Path getWorkspacePath() {
        return workspacePath;
    }

    public void setWorkspacePath(Path workspacePath) {
        this.workspacePath = workspacePath;
    }

}