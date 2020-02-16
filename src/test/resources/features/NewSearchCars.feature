@Search-Cars
Feature: Acceptance testing to validate Search cars page is working
  In order to validate that
  the search cars page is working fine
  we will do the acceptance testing

  @Search-Cars-Positive
  Scenario: Validate new search cars page
    Given I am on a Home Page "https://www.carsguide.com.au/" of Car for Sale
    When I move to the menu
      | Menu       |
      | buy + sell |
    And click on New search cars link
    And select new carbrand as "BMW" from AnyMake dropdown
    And select new carmodel as "1 Series" series from AnyModel dropdown
    And select new car location as "NSW - Sydney" from AnyLocation dropdown
    And select new car price as "$60,000" from Price dropdown
    And click on Find My Next Car button
    Then I should see the list of searched new cars
    And the page title should be "New Bmw 1 Series Under 60000 for Sale Sydney NSW | carsguide"