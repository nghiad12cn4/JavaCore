Feature: Subscribe email on Homepage

  Background: Access to the Home page
    Given Access to the Home page
#1
  Scenario: Show error message when user registry leave blank or content not correct format
    When The user attempt to input email blank or NOT correct format
    Then The message "* Email không đúng định dạng" is shown
    And The border of email is red
##2
#  Scenario: Show error message when user registry existed email
#    When The user attempt to input existed email
#    And The user click button Dangky
#    And The alert is shown
#    And The user click accept button
#    Then The focus element is txtEmail
#    And The content email clears

    #3
  Scenario: User attempt to input valid email, show the extra description panel
    When Input valid email (not existed)
    And The user click button Dangky3
    Then The extra description panel is shown
    And The Hovaten field is blank
    And The "Không xác định" option is picked on Sex field
    And The "Nhận tất cả các loại tin" option is picked on MessegeType field
    And The "Nhận tất cả các loại tin" option is picked on MessegeType field

##        4
#  Scenario: User attempt to input blank Hovaten field on Add Information form and click Dongy, the messagse is shown
#    Given User input valid email (not existed) 2
#    And Click DangKy button
#    And Show div Subribe extra panel
#    When Input blank ho va ten field
#    And Click Dong y button
#    Then The message4 "* Bạn cần phải nhập dữ liệu" is shown
#    And Border is red
#    And Background is yellow
#
##          5
#  Scenario: User attempt to input something in AddingInformation form then press Escape button
#    Given User input valid email (not existed) 5
#    And User Click DangKy button
#    And User Show div Subribe extra panel
#    When User input something hovaten field
#    And Press escape button
#    Then The subribe panel is hide
#
#
##            6
#  Scenario: User attempt to input valid all field on Subcribe panel, the popup is shown
#    Given User input valid email (not existed) 6
#    And User Click DangKy button6
#    And User Show div Subribe extra panel6
#    When User input valid value for all field
#    And User click Dong y button6
#    Then The popup "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký" is shown
#
#
#
#
#
