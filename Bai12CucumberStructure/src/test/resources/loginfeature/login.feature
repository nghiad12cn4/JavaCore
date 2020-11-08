Feature:    Login Feature
  Background: The Login page is shown
    Given Navigate to login page

#Testcase 1, 2
  Scenario: Show error message when leave blank Username Password
    When The user attempt login with Username blank  and Password blank
    Then The message "Vui lòng nhập email." will be showed below Email field
    And The message "Xin vui lòng nhập mật khẩu." will be showed below Passoword field

#Testcase 3
  Scenario: The suggestion is shown when user input email
    When User input email
    Then The suggestion is shown
    And User can choose matched item from suggestion

#Testcase 4
  Scenario: Show password as a plan text and secret text
    Given The Password is shown
    When The user enter the password then try to show their password before hide it again
    Then The password display as a plan text
    And The password show as a secret character after click hide

#Testcase 5
  Scenario: Show error message when leave blank Username Password
    When The user attempt to input invalid email address
    Then The message "Nhập địa chỉ email hợp lệ." will be shown


#Testcase 6
  Scenario: Show message when user input user pass NOT exist
    When User input email NOT exist, User input password NOT exist
    Then The error message "Lỗi: Không khớp với Địa chỉ E-mail và / hoặc Mật khẩu." is shown

