package utilities;

import org.openqa.selenium.WebDriver;

public class DriverContext {

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverContext.driver = driver;
    }

}
