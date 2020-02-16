package pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverContext;

public class CommonActions {

    public void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    public void moveToElement(WebElement webElement) {
        Actions action = new Actions(DriverContext.driver);
        action.moveToElement(webElement).perform();
    }

    public void selectWebElementByVisibleText(WebElement webElement, String visibleText) {
        Select selectWebElement = new Select(webElement);
        selectWebElement.selectByVisibleText(visibleText);
    }

    public String getPageTitle() {
        return DriverContext.driver.getTitle();
    }

    public void pageFactoryInitElements(Object pageObject) {
        PageFactory.initElements(DriverContext.driver, pageObject);
    }
}
