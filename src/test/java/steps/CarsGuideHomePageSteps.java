package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.actions.CarsGuideHomePageActions;
import utilities.TestUtils;

import java.util.List;

public class CarsGuideHomePageSteps {

    private CarsGuideHomePageActions carsGuideHomePageActions;
    private TestUtils testUtils;

    public CarsGuideHomePageSteps(CarsGuideHomePageActions carsGuideHomePageActions, TestUtils testUtils) {
        this.carsGuideHomePageActions = carsGuideHomePageActions;
        this.testUtils = testUtils;
    }

    @Given("^I am on a Home Page \"([^\"]*)\" of Car for Sale$")
    public void iAmOnAHomePageOfCarForSale(String websiteURL) {
        testUtils.openBrowser(websiteURL);

    }

    @When("^I move to the menu$")
    public void iMoveToTheMenu(List<String> list) {
        String menu = list.get(1);
        System.out.println("Menu selected is : " + menu);
        carsGuideHomePageActions.moveToBuyPlusSellMenu();
    }

    @And("^click on New search cars link$")
    public void clickOnNewSearchCarsLink() {
        carsGuideHomePageActions.clickOnNewCarsMenu();
    }

    @And("^click on Used search cars link$")
    public void clickOnUsedSearchCarsLink() {
        carsGuideHomePageActions.clickOnUsedCarsMenu();
    }

}
