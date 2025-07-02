Feature: Testing users API

  Background:
    * url baseUrl
    * configure headers = { 'x-api-key': 'reqres-free-v1' }

  @smoke
  Scenario: Get all users successfully
    Given path '/api/users?page=2'
    And retry until responseStatus == 200
    When method get
    Then status 200
    And match karate.response.header('Content-Type') contains 'application/json'


  Scenario: Get a user by id successfully
    * def userId = 1
    Given path '/api/users', userId
    When method get
    Then status 200
    And match response.data.id == userId

