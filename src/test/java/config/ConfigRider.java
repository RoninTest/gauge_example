package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRider {
    private static final Properties properties = new Properties();

    static {
            String environment = System.getProperty("env", "prod");
            String filePath = "env/" + environment + "/" + environment + ".properties";
        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Config Directory couldn't read");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
