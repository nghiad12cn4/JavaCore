Feature:    Show error message when user input invalid email

  Scenario: Show error message when leave blank Username Password
    Given The login page is shown
    When The user attempt Invalid email address
    Then The message “Enter a valid email address” will be shown
