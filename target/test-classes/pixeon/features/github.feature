@github
Feature: Github
  Second Challenge - QA test

  Scenario: Verify what file or folder is the oldest commit
    Given I am on the github website
    When I search for "selenium"
    And I access the SeleniumHQ/selenium repository
    Then I should see the file or folder with the oldest commit