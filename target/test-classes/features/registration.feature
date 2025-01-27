Feature: Registration feature

  Scenario Outline: Validating Registration feature using old and new user data
    Given the browser is open and navigated to the url
    When user navigates to Login page
    And user enters username "<username>" email "<email>" and password "<password>"
    Then verify the status "<Expected Status>" of registration
    And browser is closed

    Examples: 
      | username   | email                | password    | Expected Status |
      | timdavid46 | timdavid23@gmail.com | Tim@143     | success         |
      | tomsmith23 | tomsmith23@gmail.com | Tom@1235874 | fail            |
