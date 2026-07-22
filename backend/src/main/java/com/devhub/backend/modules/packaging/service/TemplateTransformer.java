package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.model.PackageContext;

public interface TemplateTransformer {

    void transform(PackageContext context);
}
