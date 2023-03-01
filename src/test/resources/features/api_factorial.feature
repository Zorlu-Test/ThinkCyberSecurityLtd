Feature: UI Think Cyber Security tests
  @API
  Scenario Outline: Post a number verify  respond body and headers
    Given  I post the number "<Numbers>"
    Then Verify  status code should be 200
    And The response content type should be "application/json"
    And Respond body answer expected result
    And The header contains date

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

    # Can add example table  in order to run multiple values
    # Can be add other headers I cut a bit shorter