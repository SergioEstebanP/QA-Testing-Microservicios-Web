Feature: Testing petstore.swagger.io services related to store services

  Scenario Outline:
    When I request to do '<operation>' operation against the petStore store service
    Then I should get <expectedStatusCode> status store code
    And The value for the '<key>' after the '<operation>' should be '<value>'

    Examples:
      | operation | expectedStatusCode | key    | operation | value  |
      | post      | 200                | status | post      | placed |
      | get       | 200                | status | get       | 6      |

  Scenario Outline:
    When I request to do '<operation>' operation by <id> against the petStore store service
    Then I should get <expectedStatusCode> status store code
    And The value for the '<key>' after the '<operation>' should be '<value>'

    Examples:
      | operation | id | expectedStatusCode | key | operation | value |
      | get       | 1  | 200                | id  | get       | 1     |

  Scenario Outline:
    When I request to do '<operation>' operation by <id> against the petStore store service
    Then I should get <expectedStatusCode> status store code

  Examples:
  | operation | id | expectedStatusCode |
  | delete    | 1  | 200                |
