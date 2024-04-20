package dev.justedlev.common.utils;

import java.util.UUID;

public final class Generator {
    private Generator() {
        throw new IllegalStateException("Util class");
    }

    public static String generateFileName() {
        return UUID.randomUUID().toString();
    }
}
