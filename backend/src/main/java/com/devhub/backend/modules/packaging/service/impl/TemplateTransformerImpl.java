package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.service.TemplateTransformer;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class TemplateTransformerImpl implements TemplateTransformer {

    @Override
    public void transform(Path workspace, PackageContext context) {

    }
}
