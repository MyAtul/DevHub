package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageType;
import com.devhub.backend.modules.packaging.model.PackageContext;
import org.springframework.stereotype.Service;

import java.nio.file.Path;


public interface TemplateResolver {

    Path resolveTemplate(PackageContext context);

}
