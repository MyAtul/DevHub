package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.dto.PackageType;
import com.devhub.backend.modules.packaging.service.TemplateResolver;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class TemplateResolverImpl implements TemplateResolver {
    @Override
    public Path resolveTemplate(String moduleName, PackageType packageType) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
