Feature: Navigation and Access to Health Programs

  Scenario: Navigate to Tobacco program and access quit tobacco content
    Given the browser is open and navigated to the url
    When user hover over PROGRAMS nav-Link
    And user clicks Tobacco link
    Then validate Tobacco link is navigating to Tobacco page
    When user clicks Quit Tobacco
    Then validate page is navigated to Quit Tobacco content
    And browser is closed

  Scenario: Navigate to AHEC Scholars program and access content
    Given the browser is open and navigated to the url
    When user hover over PROGRAMS nav-Link
    And user clicks AHEC Scholars link
    Then validate AHEC Scholars link is navigating to AHEC Scholars page
    And validate AHEC Scholars content "The Scholars Program is nationally recognized and only 150 students in the state of Florida are able to join this elite program."
    And browser is closed

  Scenario: Navigate to Healthy Aging program and access content
    Given the browser is open and navigated to the url
    When user hover over PROGRAMS nav-Link
    And user clicks Healthy Aging link
    Then validate Healthy Aging link is navigating to Healthy Aging page
    And validate the content of fourth fusion-li-item is "Reduce and manage fatigue"
    And browser is closed

  Scenario: Navigate to Covering Florida program and access content
    Given the browser is open and navigated to the url
    When user hover over PROGRAMS nav-Link
    And user clicks Covering Florida link
    Then validate Covering Florida link is navigating to Covering Florida page
    And validate the content in main where content-box-heading count 5
    And browser is closed
