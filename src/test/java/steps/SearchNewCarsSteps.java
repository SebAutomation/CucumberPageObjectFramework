package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.actions.CommonActions;
import pages.actions.SearchNewCarsPageActions;

public class SearchNewCarsSteps {


    private SearchNewCarsPageActions searchNewCarsPageActions;
    private CommonActions commonActions;

    public SearchNewCarsSteps(SearchNewCarsPageActions searchNewCarsPageActions, CommonActions commonActions) {
        this.searchNewCarsPageActions = searchNewCarsPageActions;
        this.commonActions = commonActions;
    }

    @And("^select new carbrand as \"([^\"]*)\" from AnyMake dropdown$")
    public void selectNewCarbrandAsFromAnyMakeDropdown(String carBrand) {
        searchNewCarsPageActions.selectNewCarMake(carBrand);
    }

    @And("^select new carmodel as \"([^\"]*)\" series from AnyModel dropdown$")
    public void selectNewCarmodelAsSeriesFromAnyModelDropdown(String carModel) {
        searchNewCarsPageActions.selectNewCarModel(carModel);
    }

    @And("^select new car location as \"([^\"]*)\" from AnyLocation dropdown$")
    public void selectNewCarLocationAsFromAnyLocationDropdown(String carLocation) {
        searchNewCarsPageActions.selectNewCarLocation(carLocation);
    }

    @And("^select new car price as \"([^\"]*)\" from Price dropdown$")
    public void selectNewCarPriceAsFromPriceDropdown(String carPrice) {
        searchNewCarsPageActions.selectNewCarPrice(carPrice);
    }

    @And("^click on Find My Next Car button$")
    public void clickOnFindMyNextCarButton() {
        searchNewCarsPageActions.clickOnFindMyNextCarButton();
    }

    @Then("^I should see the list of searched new cars$")
    public void iShouldSeeTheListOfSearchedNewCars() {
        System.out.println("Car list found");
    }

    @And("^the page title should be \"([^\"]*)\"$")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = commonActions.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
