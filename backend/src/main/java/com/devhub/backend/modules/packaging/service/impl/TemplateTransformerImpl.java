package com.devhub.backend.modules.packaging.service.impl;

import com.devhub.backend.modules.packaging.exception.PackageGenerationException;
import com.devhub.backend.modules.packaging.model.PackageContext;
import com.devhub.backend.modules.packaging.model.TemplatePlaceholders;
import com.devhub.backend.modules.packaging.service.TemplateTransformer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TemplateTransformerImpl implements TemplateTransformer {

    @Override
    public void transform(PackageContext context) {

        Map<String,String> placeholders = buildPlaceholderMap(context);

        transformWorkspace(
                context.getWorkspacePath(),
                placeholders
        );

    }


    private Map<String, String> buildPlaceholderMap(PackageContext context) {

        Map<String, String> placeholders = new HashMap<>();

        placeholders.put(TemplatePlaceholders.GROUP_ID, context.getGroupId());
        placeholders.put(TemplatePlaceholders.ARTIFACT_ID, context.getArtifactId());
        placeholders.put(TemplatePlaceholders.PACKAGE_NAME, context.getPackageName());

        return placeholders;
    }

    private boolean isTextFile(Path file){

        String fileName = file.getFileName().toString().toLowerCase();

        return TEXT_FILE_EXTENSIONS.stream()
                .anyMatch(fileName::endsWith);
    }

    private void transformWorkspace(Path workspace, Map<String, String> placeholders) {

        try {

            Files.walk(workspace)
                    .filter(Files::isRegularFile)
                    .filter(this::isTextFile)
                    .forEach(file -> transformFile(file, placeholders));

        } catch (IOException exception) {

            throw new PackageGenerationException(
                    "Failed to transform workspace.",
                    exception
            );
        }
    }

    private void transformFile(Path file,Map<String ,String> placeholders){

        try{

            String content = Files.readString(file);

            for (Map.Entry<String,String> placeholder : placeholders.entrySet()){

                content = content.replace(
                        placeholder.getKey(),
                        placeholder.getValue()
                );
            }

            Files.writeString(file,content);

        } catch (IOException exception) {
            throw new PackageGenerationException(
                    "Failed to transform file." + file,
                    exception
            );
        }
    }

    private static final Set<String> TEXT_FILE_EXTENSIONS = Set.of(
            ".java",
            ".xml",
            ".properties",
            ".yml",
            ".yaml",
            ".json",
            ".md",
            ".txt",
            ".html",
            ".css",
            ".js",
            ".ts",
            ".tsx"
    );


}
