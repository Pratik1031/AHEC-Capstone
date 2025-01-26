Feature: Registration Feature

  Scenario Outline: Validating Registration feature using old and new user data
    Given the browser is open and navigated to the URL
    When the user navigates to the Login page
    And the user enters username "<username>", email "<email>", and password "<password>"
    Then the registration should "<Expected Status>"
    And the browser is closed

    Examples: 
      | username             | email               | password   | Expected Status |
      | timdavid32@gmail.com | timdavid@gmail.com  | Tim123@143 | Fail            |
      | timdavid@gmail.com   | timdavid@gmail.com  | Tim@143    | Success         |
      | tomsmith             | tom.smith@gmail.com | Tom@125874 | Success         |
