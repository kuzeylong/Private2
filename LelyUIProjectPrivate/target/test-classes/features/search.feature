Feature: Search Functionality on Lely Website

  Scenario: Verify Search Functionality
    Given I navigate to the "lely" environment using the Chrome browser with expected title "Lely Global - Lely"
    When I maximize the browser window
    And I accept cookies
    When I click the search button
    Then I verify the search area is displayed
    When I enter "happy" into the search area and click the search button
    Then Verify that all search results contain the word "happy"
