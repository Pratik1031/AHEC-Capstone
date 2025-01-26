Feature: Form submission

  Scenario Outline: Successful Form Submission
    Given the browser is open and navigated to the url
    When user hover over PROGRAMS nav-Link
    And user clicks Healthy Aging link
    And user enters firstname "<first name>" , lastname "<last name>" , phone "<phone>" and email "<email>" in form
    And selects the appropriate options
    And clicks submit button
    Then Successful form submission message <Submission Message> is displayed
    And browser is closed

    Examples: 
      | first name | last name | phone      | email               | Submission Message                                                     |
      | Tim        | David     | 6304469682 | tim.david@gmail.com | "Thank you for filling out the form. Your response has been recorded." |
