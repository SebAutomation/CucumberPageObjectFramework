package pages.actions;

import pages.locators.CarsGuideHomePageLocators;

public class CarsGuideHomePageActions {

    private CarsGuideHomePageLocators carsGuideHomePageLocators;
    private CommonActions commonActions;

    public CarsGuideHomePageActions(CarsGuideHomePageLocators carsGuideHomePageLocators, CommonActions commonActions) {
        this.carsGuideHomePageLocators = carsGuideHomePageLocators;
        this.commonActions = commonActions;
        commonActions.pageFactoryInitElements(carsGuideHomePageLocators);
    }

    public void moveToBuyPlusSellMenu() {
        commonActions.moveToElement(carsGuideHomePageLocators.buyPlusSaleLink);
    }

    public void clickOnSearchCarsMenu() {
        commonActions.clickOnElement(carsGuideHomePageLocators.searchCarsLink);
    }

    public void clickOnNewCarsMenu() {
        commonActions.clickOnElement(carsGuideHomePageLocators.newCarsLink);
    }

    public void clickOnUsedCarsMenu() {
        commonActions.clickOnElement(carsGuideHomePageLocators.usedCarsLink);
    }

    public void clickOnSellMyCarMenu() {
        commonActions.clickOnElement(carsGuideHomePageLocators.sellMyCarLink);
    }

    public void moveToReviewsMenu() {
        commonActions.moveToElement(carsGuideHomePageLocators.reviewsLink);
    }
}
