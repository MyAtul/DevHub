package com.devhub.backend.modules.module.controller;

import com.devhub.backend.modules.module.service.ModuleDownloadService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/modules")
public class ModuleDownloadController {

    private final ModuleDownloadService moduleDownloadService;

    public ModuleDownloadController(ModuleDownloadService moduleDownloadService) {
        this.moduleDownloadService = moduleDownloadService;
    }

    @GetMapping("/authentication/download/backend")
    public ResponseEntity<Resource> downloadBackend() {

        Resource resource = moduleDownloadService.downloadAuthenticationBackend();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=backend.zip"
                )
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/authentication/download/frontend")
    public ResponseEntity<Resource> downloadFrontend() {

        Resource resource = moduleDownloadService.downloadAuthenticationFrontend();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=frontend.zip"
                )
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/authentication/download/full")
    public ResponseEntity<Resource> downloadFullStack() {

        Resource resource = moduleDownloadService.downloadAuthenticationFullStack();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=fullstack.zip"
                )
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}