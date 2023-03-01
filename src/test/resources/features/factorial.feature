Feature: Think Cyber Security tests


  Background:
    Given I am on the website
  @UI
  Scenario Outline: Validate form validation styling
    When I enter an invalid input "<invalidInput>"
    Then I should see the red form validation styling

    Examples:
      | invalidInput |
      | a            |
      | ab           |
      | Abc          |
      | a*           |
      | 1 1          |
      |              |
      | 1.2          |
      | 1,5          |
      | 1, 2         |
      | -2           |
      | a a          |
      | -            |
      | _3           |

  @UI
  Scenario: Calculate factorial of 5
    When I input the number 5 and click on Calculate
    Then I should see the result 120

  @UI
  Scenario Outline:  Calculate factorial of bunch of numbers

    When I input the number "<Numbers>"
    Then I should see expected Result

    Examples:
      | Numbers |
      | 111     |
      | 0       |
      | 1       |
      | 11      |
      | 18      |
      | 22      |
      | 99      |
      | 100     |
      | 900     |
      | 1000    |
      | 1001    |
      | 01      |

  @UI
  Scenario:  Calculate by press enter
    When I input  the number 3 and press enter
    Then Verify  the number calculated


