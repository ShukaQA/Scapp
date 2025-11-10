package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/mobile.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load mobile.properties", e);
        }
    }

    public static String get(String key) {
        String envValue = System.getenv(key);
        if (envValue != null) {
            return envValue;
        }
        return properties.getProperty(key);
    }

    // ✅ Added method
    public static String getOrDefault(String key, String defaultValue) {
        String envValue = System.getenv(key);
        if (envValue != null) {
            return envValue;
        }
        return properties.getProperty(key, defaultValue);
    }
}
