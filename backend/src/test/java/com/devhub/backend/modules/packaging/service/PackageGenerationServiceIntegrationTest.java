package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageRequest;
import com.devhub.backend.modules.packaging.dto.PackageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PackageGenerationServiceIntegrationTest {

    @Autowired
    private PackageGenerationService packageGenerationService;

    @Test
    void shouldGenerateAuthenticationBackendPackage() throws Exception {

        PackageRequest request = new PackageRequest(
                "authentication",
                PackageType.BACKEND,
                "com.example",
                "demo-auth",
                "com.example.demo.auth",
                "DemoApplication"
        );

        byte[] packageBytes =
                packageGenerationService.generatePackage(request);

        assertNotNull(packageBytes);
        assertTrue(packageBytes.length > 0);

        Path output =
                Path.of("generated-authentication-package.zip");

        Files.write(output, packageBytes);

        System.out.println("--------------------------------------");
        System.out.println("ZIP generated successfully");
        System.out.println(output.toAbsolutePath());
        System.out.println("--------------------------------------");
    }
}