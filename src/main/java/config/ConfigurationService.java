package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {

    private Logger logger = LoggerFactory.getLogger(ConfigurationService.class);
    private Properties properties;
    private static final String GLOBAL_CONFIG_PATH = "./src/main/java/config/GlobalConfig.properties";

    public String getProperty(String key) {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(key);
    }

    private void readProperties() {
        try {
            File propertiesFile = new File(GLOBAL_CONFIG_PATH);
            FileInputStream propertiesFileInputStream = new FileInputStream(propertiesFile);
            properties = new Properties();
            properties.load(propertiesFileInputStream);
        } catch (IOException e) {
            logger.error("Failure to read configuration file: {}", e);
        }
    }
}
