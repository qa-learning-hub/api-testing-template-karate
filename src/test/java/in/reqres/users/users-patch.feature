Feature:  Testing users API - PATH requests

  Background:
    * url baseUrl
    * configure headers  = { 'x-api-key': 'reqres-free-v1' }

    Scenario: Update a user successfully
      * def updateUser =
        """
        {
          "name": "Camilo"
        }
        """
      Given path '/api/users/2'
      And request updateUser
      When method patch
      Then status 200

      * def expectedName = updateUser.name
      And match response.name == expectedName
      And match response ==
        """
        {
          "name": "#string",
          "job": "#notpresent",
          "updatedAt": "#notnull"
        }
        """