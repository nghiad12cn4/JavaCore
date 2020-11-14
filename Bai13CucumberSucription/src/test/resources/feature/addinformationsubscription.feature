Feature: Add information subcription
#        4
  Scenario: User attempt to input blank Hovaten field on Add Information form and click Dongy, the messagse is shown
    Given The information subscription is shown
    When Input blank ho va ten field
    And Click Dong y button
    Then The message4 "* Bạn cần phải nhập dữ liệu" is shown
    And Border is red
    And Background is yellow

#          5
  Scenario: User attempt to input something in AddingInformation form then press Escape button
    Given The information subscription is shown
    When User input something hovaten field
    And Press escape button
    Then The subribe panel is hide


#            6
  Scenario: User attempt to input valid all field on Subcribe panel, the popup is shown
    Given The information subscription is shown
    When User input valid value for all field
    Then The popup "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký" is shown

