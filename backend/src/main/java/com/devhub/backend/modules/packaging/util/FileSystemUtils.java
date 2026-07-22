package com.devhub.backend.modules.packaging.util;

import com.devhub.backend.modules.packaging.exception.PackageGenerationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public final class FileSystemUtils {

    private FileSystemUtils(){
        throw new UnsupportedOperationException(
                "Utility class cannot be instantiated."
        );
    }

    public static void copyDirectory(Path source,Path target){

        if(!Files.exists(source)){
            throw new PackageGenerationException(
                    "Source directory does not exist: "+source
            );
        }

        if(!Files.isDirectory(source)){
            throw new PackageGenerationException(
                    "Source path is not a directory: " + source
            );
        }

        try{

            Files.walkFileTree(source,new SimpleFileVisitor<>(){

                @Override
                public FileVisitResult preVisitDirectory(Path directory,
                                                         BasicFileAttributes attributes)
                        throws IOException{

                    Path destination = target.resolve(source.relativize(directory));

                    Files.createDirectories(destination);

                    return FileVisitResult.CONTINUE;

                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
                throws IOException{

                    Path destination = target.resolve(source.relativize(file));

                    Files.copy(
                            file,
                            destination,
                            StandardCopyOption.REPLACE_EXISTING
                    );
                    return FileVisitResult.CONTINUE;
                }
            });
        }catch (IOException exception){
            throw new PackageGenerationException(
                    "Failed to copy directory from '%s' to '%s'."
                            .formatted(source,target),
                    exception
            );
        }
    }

    public static void deleteDirectory(Path directory){

        if(directory == null || Files.notExists(directory)){
            return;
        }

        try{

            Files.walkFileTree(directory,new SimpleFileVisitor<>(){

                @Override
                public FileVisitResult visitFile(Path file,BasicFileAttributes attributes) throws IOException {

                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir,IOException exception) throws IOException {

                    if(exception != null){
                        throw exception;
                    }

                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }catch (IOException exception){
            throw new PackageGenerationException(
                    "Failed to delete directory: " + directory,
                    exception
            );
        }

    }
}
