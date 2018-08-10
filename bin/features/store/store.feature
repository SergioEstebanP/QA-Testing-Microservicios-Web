Feature: Testing petstore.swagger.io services related to store services

  @test
  Scenario Outline:
    When I request to do '<operation>' operation against the petStore store service
    Then I should get <expectedStatusCode> status store code
    And The value for the '<key>' after the '<operation>' should be '<value>'

    Examples:
      | operation | expectedStatusCode | key    | operation | value |
      | get       | 200                | status | get       | 6     |


