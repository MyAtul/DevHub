package com.devhub.backend.modules.packaging.model;

public final class TemplatePlaceholders {

    public static final String GROUP_ID = "${GROUP_ID}";
    public static final String ARTIFACT_ID = "${ARTIFACT_ID}";
    public static final String PACKAGE_NAME = "${PACKAGE_NAME}";
    public static final String APPLICATION_NAME = "${APPLICATION_NAME}";

    private TemplatePlaceholders() {
        throw new UnsupportedOperationException("Utility class");
    }
}
