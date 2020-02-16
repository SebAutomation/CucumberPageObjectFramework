package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.actions.SearchUsedCarsPageActions;

public class SearchUsedCarsSteps {

    private SearchUsedCarsPageActions searchUsedCarsPageActions;

    public SearchUsedCarsSteps(SearchUsedCarsPageActions searchUsedCarsPageActions) {
        this.searchUsedCarsPageActions = searchUsedCarsPageActions;
    }

    @And("^select used carbrand as \"([^\"]*)\" from AnyMake dropdown$")
    public void selectUsedCarbrandAsFromAnyMakeDropdown(String carBrand) {
        searchUsedCarsPageActions.selectUsedCarMake(carBrand);
    }

    @And("^select used carmodel as \"([^\"]*)\" series from AnyModel dropdown$")
    public void selectUsedCarmodelAsSeriesFromAnyModelDropdown(String carModel) {
        searchUsedCarsPageActions.selectUsedCarModel(carModel);
    }

    @And("^select used car location as \"([^\"]*)\" from AnyLocation dropdown$")
    public void selectUsedCarLocationAsFromAnyLocationDropdown(String carLocation) {
        searchUsedCarsPageActions.selectUsedCarLocation(carLocation);
    }

    @And("^select used car price as \"([^\"]*)\" from Price dropdown$")
    public void selectUsedCarPriceAsFromPriceDropdown(String carPrice) {
        searchUsedCarsPageActions.selectUsedCarPrice(carPrice);
    }

    @And("^click on Find My Next Car button for used cars$")
    public void clickOnFindMyNextCarButtonForUsedCars() {
        searchUsedCarsPageActions.clickOnFindMyNextCarButtonForUsedCars();
    }

    @Then("^I should see the list of searched used cars$")
    public void iShouldSeeTheListOfSearchedUsedCars() {
        System.out.println("Used Car list found");
    }

}
