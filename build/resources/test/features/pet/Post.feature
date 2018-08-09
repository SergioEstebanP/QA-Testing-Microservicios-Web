Feature: Testing petstore.swagger.io services

  Scenario Outline:
    When I request to post a pet stored in json file
    Then I should get <expectedStatusCode> status code
    And The value for the '<key>' after post operation should be '<value>'

    Examples:
      | key    | value     | expectedStatusCode |
      | status | available | 200                |