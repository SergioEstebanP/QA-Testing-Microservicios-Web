Feature: As a consumer I create a new dog entry in the petstore

  @qa
  Scenario Outline: I upload a new pet into the store SUCCESSFULLY
    Given I set base URL for the request to base petstore URL
    And I set endpoint to "/pet"
    And I set header "access-token" to "valid_token"
    And I set body with this information:
    """
    {
      "id": 0,
      "category": {
        "id": 0,
        "name": "string"
      },
      "name": "<valueOfName>",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "string"
        }
      ],
      "status": "available"
    }
    """
    And I set header "accept" to value "application/json"
    And I set header "Content-Type" to value "application/json"
    And I set operation request to "POST"
    When I execute the request
    Then the status code should be a 200
    And the response json path "id" should be a valid id
    And the response json path "name" should be "<valueOfName>"

    Examples:
      | valueOfName |
      | pipo        |

  Scenario: I upload a new pet into the store SUCCESSFULLY
    Given I set base URL for the request to base petstore URL
    And I set endpoint to "/pet"
    And I set body with this template: "src/test/resources/requestBodies/postPet.json"
    And I set headers with:
      | Content-Type | application/json |
      | accept       | application/json |
