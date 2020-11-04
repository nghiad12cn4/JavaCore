Feature:   The suggestion is shown when user input email
  Scenario: The suggestion is shown when user input email
    Given The login page is shown3
    When User input email
    Then The suggestion is shown
