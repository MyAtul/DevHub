package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageType;
import org.springframework.stereotype.Service;

import java.nio.file.Path;


public interface TemplateResolver {

    Path resolveTemplate(
            String moduleName,
            PackageType packageType
    );

}
