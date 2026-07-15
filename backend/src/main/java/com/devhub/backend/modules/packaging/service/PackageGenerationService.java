package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageRequest;

public interface PackageGenerationService {

    byte[] generatePackage(PackageRequest request);
}
