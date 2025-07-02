Feature:  Testing users API - PUT requests

  Background:
    * url baseUrl
    * configure headers = { 'x-api-key': 'reqres-free-v1' }

  Scenario: Update a user successfully
    * def updateUser =
      """
      {
        "name": "Camilo",
        "job": "Developer"
      }
      """
    Given path '/api/users/2'
    And request updateUser
    When method put
    Then status 200

    * def expectedName = updateUser.name
    * def expectedJob = updateUser.job

    And match response.name == expectedName
    And match response.job == expectedJob
    And match response ==
      """
      {
        "name": "#string",
        "job": "#string",
        "updatedAt": "#notnull"
      }
      """