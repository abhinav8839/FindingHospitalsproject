Feature:  TC3_Invalid_Details
Scenario: Successful demo booking with negative input
    Given the user navigates to health & wellness Plan under For Corporates section
    When user enters all the fields with invalid inputs
    Then Schedule a demo button is disabled and user clicks it but it will not work
    And print test failed in the console and clears all inputs
