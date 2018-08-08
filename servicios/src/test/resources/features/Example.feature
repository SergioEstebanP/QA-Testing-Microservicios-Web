Feature: Basic API feature

#  @influxdb
  Scenario Outline: Get pet by a given ID
    When I request to get a pet by ID "<petID>"
    Then I should get <expectedStatusCode> status code
    And The value for the "<key>" after get operation should be "<value>"

    Examples:
      | petID | key  | value | expectedStatusCode |
      | 0     | code | 1     | 404                |