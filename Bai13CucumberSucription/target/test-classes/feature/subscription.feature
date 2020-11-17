Feature: Subscribe email on Homepage
##1
#  Scenario Outline: Show error message when user registry leave blank or content not correct format
#    Given Access to the Home page
#    When The user attempt to input <email> invalid
#    Then The message "* Email không đúng định dạng" is shown
#    And The border of email is red
#
#    Examples:
#      | email      |
#      | khanh.tx   |
#      | @yahoo.com |
#
##2
#  Scenario Outline: Show error message when user registry existed email
#    Given Access to the Home page
#    When The user attempt to input existed email <email>
#    And The alert "E-mail <email> đã được sử dụng, bạn hãy chọn một E-mail khác" is shown
#    Examples:
#      | email                |
#      | ducnghiasp@gmail.com |
#
#
#      #2.1
#  Scenario: When user registry existed email, the subscription screen focus element is email and clear email content
#    Given User attempt to existed email, the alert is shown
#    When The user click Dong y button
#    Then The focus element is txtEmail
#    And The content email clears
 #3
#  Scenario: User attempt to input valid email, show the extra description panel
#    Given Access to the Home page
#    When Input valid email (not existed)
#    Then The extra description panel is shown
#    And The Hovaten field is blank
#    And The "Không xác định" option is picked on Sex field
#    And The "Nhận tất cả các loại tin" option is picked on MessegeType field
#    And The "Nhận tất cả các loại tin" option is picked on MessegeType field
