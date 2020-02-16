package pages.actions;

import pages.locators.SearchNewCarsPageLocators;

public class SearchNewCarsPageActions {

    private SearchNewCarsPageLocators searchNewCarsPageLocators;
    private CommonActions commonActions;

    public SearchNewCarsPageActions(SearchNewCarsPageLocators searchNewCarsPageLocators, CommonActions commonActions) {
        this.searchNewCarsPageLocators = searchNewCarsPageLocators;
        this.commonActions = commonActions;
        commonActions.pageFactoryInitElements(searchNewCarsPageLocators);
    }

    public void selectNewCarMake(String carMake) {
        commonActions.selectWebElementByVisibleText(searchNewCarsPageLocators.carMakeDropDown, carMake);
    }

    public void selectNewCarModel(String carModel) {
        commonActions.selectWebElementByVisibleText(searchNewCarsPageLocators.carModelDropDown, carModel);
    }

    public void selectNewCarLocation(String carLocation) {
        commonActions.selectWebElementByVisibleText(searchNewCarsPageLocators.carLocationDropDown, carLocation);
    }

    public void selectNewCarPrice(String carPrice) {
        commonActions.selectWebElementByVisibleText(searchNewCarsPageLocators.carPriceDropDown, carPrice);
    }

    public void clickOnFindMyNextCarButton() {
        commonActions.clickOnElement(searchNewCarsPageLocators.findMyNextCarButton);
    }
}
