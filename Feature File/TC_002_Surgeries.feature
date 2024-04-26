Feature: TC2_SurgeryDetails

  Scenario: Successful retreival of popular surgeries
    Given user navigate to surgeries section
    When scrolls the page
    Then user gets a list of popular surgery and prints it
