package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuideHomePageLocators {

    @FindBy(how=How.LINK_TEXT, using="buy + sell")
    public WebElement buyPlusSaleLink;

    @FindBy(how=How.LINK_TEXT, using="reviews")
    public WebElement reviewsLink;

    @FindBy(how=How.LINK_TEXT, using="Search Cars")
    public WebElement searchCarsLink;

    @FindBy(how=How.LINK_TEXT, using="New")
    public WebElement newCarsLink;

    @FindBy(how=How.LINK_TEXT, using="Used")
    public WebElement usedCarsLink;

    @FindBy(how=How.LINK_TEXT, using="Sell my car")
    public WebElement sellMyCarLink;

}
