package pages.actions;

import pages.locators.SearchUsedCarsPageLocators;

public class SearchUsedCarsPageActions {

    private SearchUsedCarsPageLocators searchUsedCarsPageLocators;
    private CommonActions commonActions;

    public SearchUsedCarsPageActions(SearchUsedCarsPageLocators searchUsedCarsPageLocators, CommonActions commonActions) {
        this.searchUsedCarsPageLocators = searchUsedCarsPageLocators;
        this.commonActions = commonActions;
        commonActions.pageFactoryInitElements(searchUsedCarsPageLocators);
    }

    public void selectUsedCarMake(String carMake) {
        commonActions.selectWebElementByVisibleText(searchUsedCarsPageLocators.carMakeDropDown, carMake);
    }

    public void selectUsedCarModel(String carModel) {
        commonActions.selectWebElementByVisibleText(searchUsedCarsPageLocators.carModelDropDown, carModel);
    }

    public void selectUsedCarLocation(String carLocation) {
        commonActions.selectWebElementByVisibleText(searchUsedCarsPageLocators.carLocationDropDown, carLocation);
    }

    public void selectUsedCarPrice(String carPrice) {
        commonActions.selectWebElementByVisibleText(searchUsedCarsPageLocators.carPriceDropDown, carPrice);
    }

    public void clickOnFindMyNextCarButtonForUsedCars(){
        commonActions.clickOnElement(searchUsedCarsPageLocators.findMyNextCarButton);
    }
}
