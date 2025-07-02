Feature: Tesintg users API - DELETE requests

  Background:
    * url baseUrl
    * configure headers = apikey

    Scenario: Delete a user successfully
      Given path '/api/users/2'
      When method delete
      Then status 204
      And match response == ''