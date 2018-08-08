Feature: Basic API feature

#  @influxdb
  Scenario Outline: Get an existing user
    When I request to get a user by ID "<userID>"
    Then I should get <expectedStatusCode> status code
    And The value for the "<key>" after get operation should be "<value>"

    Examples:
      | userID | key        | value | expectedStatusCode |
      | 2      | first_name | Janet | 200                |