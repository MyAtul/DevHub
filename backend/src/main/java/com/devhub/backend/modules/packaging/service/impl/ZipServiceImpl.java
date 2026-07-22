package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.exception.PackageGenerationException;
import com.devhub.backend.modules.packaging.service.ZipService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ZipServiceImpl implements ZipService {

    @Override
    public Path createZip(Path workspace) {

        try{
            Path zipFile = Files.createTempFile(
                    "devhub-package-",
                    ".zip"
            );

            try(ZipOutputStream zipOutputStream =
                new ZipOutputStream(Files.newOutputStream(zipFile))){
                    zipWorkspace(
                            workspace,
                            zipOutputStream
                            );
                }

            return zipFile;
        }catch (IOException exception){
            throw new PackageGenerationException(
                    "Failed to create zip file",
                    exception
            );
        }
    }

    private void zipWorkspace(Path workspace, ZipOutputStream zipOutputStream){

        try{
            Files.walk(workspace)
                    .filter(Files::isRegularFile)
                    .forEach(file -> addFileToZip(
                            workspace,
                            file,
                            zipOutputStream
                    ));
        }catch (IOException exception){
            throw new PackageGenerationException(
                    "Failed to add workspace contents to ZIP.",
                    exception
            );
        }

    }

    private void addFileToZip(Path workspace,Path file,ZipOutputStream zipOutputStream){

        try{
            Path relativePath = workspace.relativize(file);

            ZipEntry zipEntry = new ZipEntry(
                    relativePath.toString().replace('\\','/')
            );

            zipOutputStream.putNextEntry(zipEntry);

            Files.copy(file,zipOutputStream);

            zipOutputStream.closeEntry();

        } catch (IOException exception) {
            throw new PackageGenerationException(
                    "Failed to add file in zip " + file,
                    exception
            );
        }
    }

}
