Feature: Check google search functionality

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters a text in google search box
    And hits Enter
    Then user is navigated to Search Results page
