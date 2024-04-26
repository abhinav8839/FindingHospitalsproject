Feature: TC1_SearchingDentists
  Scenario: Successful extraction of doctor details
  Given user is on practo.com website.
    When user clicks the location box and clears existing data.
    And enters required location.
    And clicks the search box to type Dentist doctors.
    Then the page starts to search for records of doctors who are Dentist and its displayed.
    And applying filters for Patient Stories, Experience, Fees, Availability and any one Sorting.
    And Fetch & display the first five Doctor details.
