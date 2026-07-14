package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.service.ZipService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class ZipServiceImpl implements ZipService {

    @Override
    public byte[] zip(Path directory) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
