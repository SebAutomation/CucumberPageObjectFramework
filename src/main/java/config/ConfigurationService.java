package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {

    private File propertiesFile = new File(".\\src\\main\\java\\config\\GlobalConfig.properties");
    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

    public String getProperty(String key) {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(key);
    }

    private void readProperties() {
        try {

            FileInputStream propertiesFileInputStream = new FileInputStream(propertiesFile);
            properties = new Properties();
            properties.load(propertiesFileInputStream);
        } catch (IOException e) {
            logger.error("Failure to read configuration file: {}", e);
        }
    }
}
