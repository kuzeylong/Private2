Feature: Download Lely TechDocs

  Scenario: Open TechDocs in Chrome Browser
    Given I navigate to the "techdocs" page using the Chrome browser
    And I accept cookies
    When I click on the dropdown
    When I scroll within the dropdown and select luna item
    When I scroll to the element with text 'LUNA en'
