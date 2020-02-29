package utilities;

import com.cucumber.listener.Reporter;
import config.ConfigurationService;
import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static utilities.BrowserType.chrome;

public class TestUtils {

    private ConfigurationService configurationService;
    private static WebDriverWait waitDriver;
    private BrowserType browserType;
    private Logger logger = LoggerFactory.getLogger(TestUtils.class);

    public TestUtils(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    public void initializeBrowser() {
        if (System.getProperty("browserType") != null) {
            browserType = BrowserType.valueOf(System.getProperty("browserType").toLowerCase());
        } else {
            browserType = chrome;
        }
        switch (browserType) {
            case chrome: {
                /*on purpose I run a particular(older) version of Chrome browser taken from property file*/
                System.setProperty("webdriver.chrome.driver", configurationService.getProperty("chromeDriver"));
                /*it runs the newest version of Chrome browser using WebDriverManager*/
                //WebDriverManager.chromedriver().setup();
                DriverContext.driver = new ChromeDriver();
                break;
            }
            case firefox: {
                //System.setProperty("webdriver.firefox.marionette", configurationService.getProperty("firefoxDriver"));
                /*it runs the newest version of Firefox browser using WebDriverManager*/
                WebDriverManager.firefoxdriver().setup();
                DriverContext.driver = new FirefoxDriver();
                break;
            }
            case ie: {
                //System.setProperty("webdriver.ie.driver", configurationService.getProperty("IEDriver"));
                /*it runs the newest version of IE browser using WebDriverManager*/
                WebDriverManager.iedriver().setup();
                DriverContext.driver = new InternetExplorerDriver();
            }
        }

        logger.info("Framework starts driver: {}", DriverContext.driver.toString());
    }

    public int getBrowserImplicitTime(){
        return Integer.valueOf(configurationService.getProperty("browserImplicitTime"));
    }

    public int getPageLoadTimeout(){
        return Integer.valueOf(configurationService.getProperty("pageLoadTimeout"));
    }

    public void maximizeBrowser(){
        DriverContext.driver.manage().window().maximize();
    }

    public void setImplicitTime(){
        waitDriver = new WebDriverWait(DriverContext.driver, getBrowserImplicitTime());
        DriverContext.driver.manage().timeouts().implicitlyWait(getBrowserImplicitTime(), TimeUnit.SECONDS);
        DriverContext.driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
    }

    public void openBrowser(String url) {
        DriverContext.driver.get(url);
        logger.info("Browser opened ({})", url);
    }

    public void closeBrowser() {
        DriverContext.driver.quit();
        logger.info("Browser closed");
    }

    public void screenshotInCaseOfFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = (scenario.getName() + TimeTool.getCurrentLocalDateTime() + ".png").replace(" ", "_");
            try {
                Reporter.addScreenCaptureFromPath(ScreenshotTool.takeScreenshot(screenshotName));
            } catch (Exception e) {
                logger.error("Failure to capture a screenshot: {}", e);
            }
        }
    }

    public void deleteCookies() {
        DriverContext.driver.manage().deleteAllCookies();
        logger.info("All cookies deleted");
    }
}

