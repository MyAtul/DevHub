package com.devhub.backend.modules.packaging.model;

import com.devhub.backend.modules.packaging.dto.PackageType;

import java.nio.file.Path;

public class PackageContext {

    private final String moduleName;

    private final PackageType packageType;

    private final String groupId;

    private final String artifactId;

    private final String packageName;

    private final String applicationName;

    private Path templatePath;

    private Path workspacePath;


    public PackageContext(String moduleName, PackageType packageType, String groupId, String artifactId, String packageName, String applicationName) {
        this.moduleName = moduleName;
        this.packageType = packageType;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.packageName = packageName;
        this.applicationName = applicationName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getApplicationName() {
        return applicationName;
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