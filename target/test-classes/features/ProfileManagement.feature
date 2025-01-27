Feature: Profile Management Features

  Scenario Outline: Validating user account management feature
    Given the browser is open and navigated to the url
    When user navigates to Login page
    And user enters username "<username>" and password "<password>" and click log in button
    Then verify the status "<Expected Status>" of login
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
      | username            | password    | Expected Status | DisplayName | new password |
      | tom.smith@gmail.com | Tom@1235874 | success         | tomsmith    | TomDavid@123 |
      | timdavid46          | Tim123@143  | success         | timdavid46  | Tim@143      |
