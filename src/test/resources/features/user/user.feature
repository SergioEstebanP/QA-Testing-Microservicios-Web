Feature: Testing petstore.swagger.io services related to user services

  # until now, generi scenario
  @test
  Scenario Outline:
    When I request to do '<userOperation>' '<operation>' operation against the petStore user service
    Then I should get <expectedStatusCode> status user code
    And The user value for the '<key>' after the '<operation>' should be '<value>'

    Examples:
      | operation | userOperation | expectedStatusCode | key | operation | value |
      | post      | createList    | 200                | id  | post      | 2311  |
      #| post      | create        | 200                | id  | post      | 2312  |

  # log
  Scenario Outline:
    When I request to do '<operation>' operation against the petStore user service to login '<user>' '<passwd>'
    Then I should get <expectedStatusCode> status user code

    Examples:
      | operation | expectedStatusCode | user        | passwd      |
      | get       | 200                | antimateria | antimateria |


  # logout the user and generic responses to actions
  Scenario Outline:
    When I request to do '<userOperation>' '<operation>' operation against the petStore user service
    Then I should get <expectedStatusCode> status user code

    Examples:
      | operation | userOperation | expectedStatusCode |
      | get       | login         | 200                |

  # getByName user
  Scenario Outline:
    When I request to do '<operation>' operation against the petStore user service to login '<user>'
    Then I should get <expectedStatusCode> status user code
    And The user value for the '<key>' after the '<operation>' should be '<value>'

    Examples:
      | operation | expectedStatusCode | user        | key      | operation | value       |
      | put       | 200                | antimateria | username | put       | antimateria |
      #| get       | 200                | antimateria | username | get       | antimateria |

  Scenario Outline:
    When I request to do '<operation>' operation against the petStore user service to login '<user>'
    Then I should get <expectedStatusCode> status user code

    Examples:
      | operation | expectedStatusCode | user        |
      | delete    | 200                | antimateria |
