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

  @smoke @sanity
  Scenario: Create a new user successfully
    * def createUser =
      """
      {
        "name": "Luisa",
        "job": "API Tester"
      }
      """
    Given path '/api/users'
    And request createUser
    When method post
    Then status 201

    * def expectedName = createUser.name
    * def expectedJob = createUser.job

    And match response.name == expectedName
    And match $.job == expectedJob
    And match response ==
      """
      {
        "name": "#string",
        "job": "#string",
        "id": "#number",
        "createdAt": "#notnull",
        "updatedAt": "#notpresent"
      }
      """

  Scenario: Create a user and find it by id
    * def createUser =
      """
      {
        "name": "Camilo",
        "job": "API Tester"
      }
      """
    Given path '/api/users'
    And request createUser
    When method post
    Then status 201
    * def userId = response.id
    * print 'user id: ', response.id
    Given path '/api/users', userId
    When method get
    Then status 200
    And match response.name == createUser.name
    And match response.id == userId

  Scenario: create a user from json file
    * def createUser = read('classpath:examples/users/payloads/createUser.json')
    * set createUser.name = 'Camilo'
    * set createUser.job = 'Developer'
    Given path '/api/users'
    And request createUser
    When method post
    Then status 201

  Scenario: create a user from json file and remove job field
    * def createUser = read('classpath:examples/users/payloads/createUser.json')
    * remove createUser.job
    Given path '/api/users'
    And request createUser
    When method post
    Then status 201

  Scenario: create a simple json object
    * set jsonObjectPayload
    |name | job       |
    |Luisa|API Tester|
    * print jsonObjectPayload
    Given path '/api/users'
    And request jsonObjectPayload
    When method post
    Then status 201

  Scenario: create a user with DataFaker
    * def dataFaker = Java.type("examples.utils.RandomDataGenerator")
    * def createUser =
      """
      {
        "name": "#(dataFaker.generateRandomName())",
        "job": "#(dataFaker.generateRandomJobTitle())"
      }
      """
    Given path '/api/users'
    And request createUser
    When method post
    Then status 201