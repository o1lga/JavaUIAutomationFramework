Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with valid data
    Given The "/" endpoint is accessed
    And Register Page is accessed from the Home Page
    And the Register form is populated with data
    And the "privacyToggleBar" from "RegisterPage" is clicked
    When the "continueButton" from "RegisterPage" is clicked
    Then the URL contains the following keyword "success"

  @run
  Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
    Given The "/" endpoint is accessed
    And Register Page is accessed from the Home Page
    And the Register form is populated with data
    When the "continueButton" from "RegisterPage" is clicked
    Then the URL contains the following keyword "register"

  @run
  Scenario Outline: Error message is displayed when registering with invalid <errorFieldName> length
    Given The "/" endpoint is accessed
    And Register Page is accessed from the Home Page
    And the Register form is populated with data as following:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | RANDOM      |
      | password  | <password>  |

    And a thread sleep of 5 seconds is executed
    When the "continueButton" from "RegisterPage" is clicked
    Then the following list of error messages is displayed:
      | <errorFieldName> must be between <min> and <max> characters |
      | Warning: You must agree to the Privacy Policy!              |

    Examples:
      | firstName | lastName                                               | password                                             | errorFieldName | min | max |
      | Random    | Grozavu                                                | 321                                                  | Password       | 4   | 20  |
      | Random    | Grozavu                                                | 1234567890123456789012321564641516541534681534615136 | Password       | 4   | 20  |
      | Random    | Grozavu12345678901234567890123779454984546452156484515 | 12345678901234567890123                              | Last Name      | 1   | 32  |