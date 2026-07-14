package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import com.devhub.backend.modules.packaging.service.PackageGenerationService;
import org.springframework.stereotype.Service;

@Service
public class PackageGenerationServiceImpl implements PackageGenerationService {

    @Override
    public byte[] generatePackage(PackageRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
