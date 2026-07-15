package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import com.devhub.backend.modules.packaging.mapper.PackageContextMapper;
import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.service.PackageGenerationService;
import org.springframework.stereotype.Service;

@Service
public class PackageGenerationServiceImpl implements PackageGenerationService {

    private final PackageContextMapper packageContextMapper;

    public PackageGenerationServiceImpl(PackageContextMapper packageContextMapper) {
        this.packageContextMapper = packageContextMapper;
    }

    @Override
    public byte[] generatePackage(PackageRequest request) {

        PackageContext context = packageContextMapper.toContext(request);
        throw new UnsupportedOperationException("Not implemented yet");
    }

}