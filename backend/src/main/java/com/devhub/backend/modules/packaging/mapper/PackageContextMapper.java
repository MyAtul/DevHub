package com.devhub.backend.modules.packaging.mapper;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import com.devhub.backend.modules.packaging.model.PackageContext;
import org.springframework.stereotype.Component;

@Component
public class PackageContextMapper {

    public PackageContext toContext(PackageRequest request) {

        return new PackageContext(
                request.moduleName(),
                request.packageType()
        );

    }

}