@API
Feature: Think Cyber Security tests

  Scenario: Post a number verify  respond body and headers
    Given  I post the number 11
    Then Verify  status code should be 200
    And The response content type should be "application/json"
    And Respond body answer expected result
    And The header contains date

    # Can add example table  in order to run multiple values
    # Can be add other headers I cut a bit shorter