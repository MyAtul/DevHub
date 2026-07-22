package com.devhub.backend.modules.packaging.service;

import com.devhub.backend.modules.packaging.dto.PackageType;
import com.devhub.backend.modules.packaging.model.PackageContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TemplateResolverTest {

    @Autowired
    private TemplateResolver templateResolver;

    @DisplayName("Should resolve authentication backend template")
    @Test
    void shouldResolveAuthenticationBackendTemplate() {

        PackageContext context = new PackageContext(
                "authentication",
                PackageType.BACKEND,
                "com.example",
                "demo-auth",
                "com.example.demo.auth",
                "DemoApplication"
        );

        Path template = templateResolver.resolveTemplate(context);

        assertNotNull(template);
        assertTrue(Files.exists(template));
        assertTrue(Files.isDirectory(template));

        assertEquals("backend", template.getFileName().toString());
        assertEquals("authentication", template.getParent().getFileName().toString());
    }
}