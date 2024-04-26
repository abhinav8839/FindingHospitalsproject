Feature:  TC4_Valid_Details
 Scenario: Successful demo booking with positive input
    Given user enters valid email.
    When user enters all the fields with valid inputs
    Then Schedule a demo button is enabled and user clicks it
    And Thankyou message is printed.