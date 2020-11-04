Feature:    Email and Password is required

  Scenario: Show error message when leave blank Username Password
    Given The login page is shown
    When The user attempt login with Username ""  and Password ""
    Then The message “Please enter your email.” And “Please enter password.” will be showed below corresponding field
