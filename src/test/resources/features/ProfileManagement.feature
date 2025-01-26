Feature: Profile Management Features

  Scenario Outline: Validating user account management feature
    Given the browser is open and navigated to the url
    When user navigates to Login page
    And user enters username "<username>" and password "<password>" and click log in button
    When user navigates to account details
    And user changes Display name as "<DisplayName>" and save changes
    Then Display name is changed and "<DisplayName>" is displayed in the hello message
    When user changes password "<password>" to "<new password>"
    And user clicks log out
    Then the Login page is displayed
    When user user enters username "<username>" and password "<new password>" and click log in button
    Then Account login successful
    And browser is closed

    Examples: 
      | username            | password     | Expected Status | DisplayName | new password |
      | tim.david@gmail.com | TimDavid@143 | success         | TIM         | Tim@143      |
