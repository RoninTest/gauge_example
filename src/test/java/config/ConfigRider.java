package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRider {
    private static final Properties properties;

    static {
        try {
            String environment = System.getProperty("env", "prod");
            String filePath = "env/" + environment + "/" + environment + ".properties";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Config Directory couldn't read");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
