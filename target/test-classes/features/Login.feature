Feature: Log in feature

  Scenario Outline: Validating login feature using valid and invalid login data
    Given the browser is open and navigated to the url
    When user navigates to Login page
    And user enters username "<username>" and password "<password>" and click log in button
    Then verify the status "<Expected Status>" of login
    And browser is closed

    Examples: 
      | username | password    | Expected Status |
      | tomsmith | Tom@1235874 | success         |
      | TimDavid | Tim@143     | fail            |
