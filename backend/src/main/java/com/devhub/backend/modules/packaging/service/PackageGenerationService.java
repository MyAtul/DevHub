package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import org.springframework.stereotype.Service;


public interface PackageGenerationService {

    byte[] generatePackage(PackageRequest request);
}
