@Search-Cars
Feature: Acceptance testing to validate used search cars page is working
  In order to validate that
  the used search cars page is working fine
  we will do the acceptance testing

  @Search-Cars-Positive
  Scenario: Validate used search cars page
    Given I am on a Home Page "https://www.carsguide.com.au/" of Car for Sale
    When I move to the menu
      | Menu       |
      | buy + sell |
    And click on Used search cars link
    And select used carbrand as "Mercedes-Benz" from AnyMake dropdown
    And select used carmodel as "AMG GT" series from AnyModel dropdown
    And select used car location as "VIC - Melbourne" from AnyLocation dropdown
    And select used car price as "$150,000" from Price dropdown
    And click on Find My Next Car button for used cars
    Then I should see the list of searched used cars
    And the page title should be "Used Mercedes-benz Amg Gt Under 150000 for Sale Melbourne VIC | carsguide"
