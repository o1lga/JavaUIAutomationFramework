Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with valid data
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page
    And the Register form is populated with data
    And the Privacy Toggle bar is enabled
    When the continueButton is clicked
    Then the URL contains the following keyword "success"

  @run
  Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page
    And the Register form is populated with data
    #And the Privacy Toggle bar is enabled
    When the continueButton is clicked
    Then the URL contains the following keyword "register"
