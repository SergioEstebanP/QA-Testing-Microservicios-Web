Feature: as a consumer I want to retrieve a pet by id

  Scenario Outline: Pet_Management_Get_Pet_By_Id_Successfully
    Given I set base URL for the request to base petstore URL
    And I set endpoint to "/pet/<petId>"
    And I set operation request to GET
    When I execute the request
    Then the status code should be a 200
    And the response jsonPath "id" should be "<petId>"

    Examples:
      | petId |
      | 1     |
