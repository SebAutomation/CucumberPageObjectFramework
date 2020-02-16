package utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Slf4j
public class ScreenshotTool {

    private static Logger logger = LoggerFactory.getLogger(ScreenshotTool.class);

    public static String takeScreenshot(String screenshotFileName) {

        //Building up the destination path for the screenshot to save
        //screenshot will be located under target/cucumber-reports/screenshots/ folder

        String directoryPath = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/";

        makeDirectoryFolder(directoryPath);

        String destinationPath = directoryPath + screenshotFileName;

        //This takes a screenshot from the driver and save it to the specified location
        File sourceFile = ((TakesScreenshot) DriverContext.driver).getScreenshotAs(OutputType.FILE);

        //Copy taken screenshot from source location to destination location
        try {
            FileUtils.copyFile(sourceFile, new File(destinationPath));
        } catch (IOException e) {
            logger.error("Failed to copy a screenshot from source location to destination: {}", e);
        }
//        return destinationPath;
        return "./screenshots/" + screenshotFileName;
    }

    public static String takeScreenshotEntirePage(String screenshotFileName) {

        String directoryPath = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/";

        makeDirectoryFolder(directoryPath);

        String destination = directoryPath + screenshotFileName;

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverContext.driver);

        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(destination));
        } catch (Exception e) {
            logger.error("Cannot take screenshot of entire page: {}", e);
        }

        return destination;
    }

    private static void makeDirectoryFolder(String directoryPath) {

        try {
            File dir = new File(directoryPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
        } catch (Exception e) {

        }
    }
}