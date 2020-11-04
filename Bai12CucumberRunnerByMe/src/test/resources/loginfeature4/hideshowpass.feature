Feature: Hide and show password

  Scenario: User can see Passwork in plaintext with show Password button or hide Passoword when user click Hide Password button
  Given The login page is shown
    When User click show/hide password
    Then Password is shown plaintext or Password show secret text
