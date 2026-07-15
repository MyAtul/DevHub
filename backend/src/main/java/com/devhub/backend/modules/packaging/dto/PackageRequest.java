package com.devhub.backend.modules.packaging.dto;

public record PackageRequest(

        String moduleName,

        PackageType packageType

) {
}