@Red

Feature: RedfinPage feature

    Scenario: Verify Home Page Loaded
      Given I open the home page
      Then Check that the home page logo is visible

    Scenario: Enter information and navigate to second page
      Given I open the home page
      When I get to the real estate page
      Then I verify that I am taken to the sunnyvale page