package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    // Load config.properties once
    static {
        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            PROPERTIES.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Private constructor (utility class)
    private ConfigReader() {}

    // Generic getter with system override support
    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        return PROPERTIES.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    // ===== Typed methods (clean usage) =====

    public static String getBrowser() {
        return get("browser");
    }

    public static String getUrl() {
        return get("url");
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getPassword() {
        return get("password");
    }

    public static int getImplicitWait() {
        return getInt("implicitWait");
    }

    public static int getExplicitWait() {
        return getInt("explicitWait");
    }

    public static boolean isHeadless() {
        return getBoolean("headless");
    }
}