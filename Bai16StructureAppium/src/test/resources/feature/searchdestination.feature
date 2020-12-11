Feature: Search destination on HomePage Booking.com

  Scenario Outline: User can search the destination when input text on destination search field
    Given The Homepage Booking.com is shown
    When The user input <destination> on the search field
    Then The destination contain keyword is shown
    Examples:
      | destination  |
      | destination1 |
      | destination2 |