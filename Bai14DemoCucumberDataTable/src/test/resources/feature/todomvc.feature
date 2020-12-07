Feature: Input text show drop down list

  Scenario: Show all items drop down list after refreshing page
    Given The todo mvc angular page is shown
    When User input 5 items on todomvc angular page
      | items |
      | Bear  |
      | Dog   |
      | Cat   |
      | Horse |
      | Tiger |
    And User refresh page
    Then The list can still show on drop down list
