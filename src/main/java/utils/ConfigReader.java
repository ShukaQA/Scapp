package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Logger log = LoggerFactory.getLogger(ConfigReader.class);

    private static Properties properties;

    static {
        try {
            log.info("Loading configuration from mobile.properties...");
            FileInputStream fis = new FileInputStream("src/main/resources/mobile.properties");
            properties = new Properties();
            properties.load(fis);
            log.info("Configuration loaded successfully.");
        } catch (IOException e) {
            log.error("Failed to load mobile.properties: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to load mobile.properties", e);
        }
    }

    public static String get(String key) {
        String envValue = System.getenv(key);
        if (envValue != null) {
            log.debug("Config key '{}' loaded from environment variable.", key);
            return envValue;
        }

        String propValue = properties.getProperty(key);

        if (propValue == null) {
            log.warn("Config key '{}' not found in properties or environment!", key);
        } else {
            log.debug("Config key '{}' loaded from mobile.properties.", key);
        }

        return propValue;
    }

    public static String getOrDefault(String key, String defaultValue) {
        String envValue = System.getenv(key);
        if (envValue != null) {
            log.debug("Config key '{}' loaded from environment variable.", key);
            return envValue;
        }

        String propValue = properties.getProperty(key);

        if (propValue == null) {
            log.warn("Config key '{}' not found. Using default value.", key);
            return defaultValue;
        }

        log.debug("Config key '{}' loaded from mobile.properties.", key);
        return propValue;
    }
}
