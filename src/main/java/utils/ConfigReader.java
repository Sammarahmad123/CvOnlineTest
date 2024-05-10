package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("properties/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getBaseUrl() {
        String environment = properties.getProperty("environment");
        return properties.getProperty("base.url." + environment);
    }
}
