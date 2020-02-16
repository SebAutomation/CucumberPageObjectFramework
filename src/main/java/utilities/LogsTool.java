package utilities;

import com.cucumber.listener.Reporter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@Slf4j
public class LogsTool {

    private static Logger logger = LoggerFactory.getLogger(LogsTool.class);
    public static void setExtentReportsInfo() {

        Capabilities caps = ((RemoteWebDriver) DriverContext.driver).getCapabilities();
        final String extentConfigPath = "src/test/resources/extent-config.xml";

        try {
            Reporter.loadXMLConfig(new File(extentConfigPath));
            logger.info("The ExtentReports configuration file has been read from: {}", extentConfigPath);
        } catch (Exception e) {
            logger.error("Failure to read extent-config.xml: {}", e);
        }

        Reporter.setSystemInfo("User", System.getProperty("user.name"));
        Reporter.setSystemInfo("Operating System", String.format("%s (%s)", System.getProperty("os.name"), System.getProperty("os.arch")));
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setSystemInfo("Java version", System.getProperty("java.version"));
        Reporter.setSystemInfo("browser", String.format("%s (%s)", caps.getBrowserName(), caps.getVersion()));
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }
}
