package com.devhub.backend.modules.packaging.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public interface ZipService {
    byte[] zip(Path directory);
}
