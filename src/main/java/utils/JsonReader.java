package utils;

import browserstack.shaded.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class JsonReader {

    private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);

    public static <T> T load(String path, Class<T> clazz) {
        logger.info("Loading test data from JSON file: {}", path);

        try {
            ObjectMapper mapper = new ObjectMapper();

            T data = mapper.readValue(new File(path), clazz);

            logger.info("Successfully loaded JSON data into class: {}", clazz.getSimpleName());
            return data;

        } catch (Exception e) {
            logger.error("Failed to load test data from JSON file: {}", path, e);
            throw new RuntimeException("Failed to load test data: " + path, e);
        }
    }
}
