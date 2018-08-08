Feature: Basic API feature

#  @influxdb
  Scenario Outline: Get an existing user
#    When I request to URI
#    And I set operation GET
#    And I set endpoint "endpoint"
#    Given I set uri ""
#    When I set content type ""
    When I request to get a user by ID "<userID>"
    Then I should get <expectedStatusCode> status code
    And The value for the "<key>" after get operation should be "<value>"

    Examples:
      | userID | key        | value | expectedStatusCode |
      | 2      | first_name | Janet | 200                |

#  @influxdb
  Scenario Outline: Create a new user successfully
    When I request to create a user
    Then I should get <expectedStatusCode> status code
    And The value for the "<key>" after post operation should be "<value>"

    Examples:
      | key  | value    | expectedStatusCode |
      | name | morpheus | 201                |

#  @influxdb
  Scenario Outline: Update an existing user
    When I request to update a user by ID "<userID>"
    Then I should get <expectedStatusCode> status code
    And The value for the "<key>" after update operation should be "<value>"

    Examples:
      | userID | key  | value    | expectedStatusCode |
      | 2      | name | morpheus | 200                |

#  @influxdb
  Scenario: Delete an existing user
    When I request to delete a user by ID "2"
    Then I should get 204 status code
