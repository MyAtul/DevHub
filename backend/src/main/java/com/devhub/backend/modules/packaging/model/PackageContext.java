package com.devhub.backend.modules.packaging.model;

import com.devhub.backend.modules.packaging.dto.PackageType;

public class PackageContext {

    private final String moduleName;
    private final PackageType packageType;

    public PackageContext(String moduleName, PackageType packageType) {
        this.moduleName = moduleName;
        this.packageType = packageType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public PackageType getPackageType() {
        return packageType;
    }
}
