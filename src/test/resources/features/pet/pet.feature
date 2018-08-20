Feature: Testing petstore.swagger.io services related to pet services

  Scenario:
    When I request to do 'post' operation by 141414 id against the petStore service
    Then I should get 200 status code

  @test
  Scenario Outline:
    When I request to do '<operation>' operation against the petStore service
    Then I should get <expectedStatusCode> status code
    And The value for the '<key>' after '<operation>' operation should be '<value>'

    Examples:
      | operation | key    | value     | expectedStatusCode |
      | post      | status | available | 200                |
     # | put       | name   | bugui     | 200                |
     # | get       | status | available | 200                |

  Scenario Outline:
    When I request to do '<operation>' operation by <id> id against the petStore service
    Then I should get <expectedStatusCode> status code
    And The value for the '<key>' after '<operation>' operation should be '<value>'

    Examples:
      | operation | id    | key | value | expectedStatusCode |
      | get       | 34341 | id  | 34341 | 200                |

