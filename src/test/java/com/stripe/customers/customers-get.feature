Feature: Test Customers API from Stripe  - get customers

  Background:
    * url baseUrlStripe
    * def encode = Java.type("com.stripe.utils.EncoderBase64")
    * header Authorization = 'Basic ' + encode.getEncode(publicKey,'')


  Scenario: get all customers
    Given path '/customers'
    When method get
    Then status 200

