Feature: karate test script for test CRUD users REST API

Background:
* url 'http://localhost:7000'

Scenario: Get all users

Given path 'users'
When method get
Then status 200
  And match $ == []

Scenario: Create a user and then get it by id

* def user =
"""
{
  "name": "Test User",
  "id":3
}
"""

Given url 'http://localhost:7000/users'
And request user
When method post
Then status 200
And match response == { id: '#notnull', msg: 'Test User'}
* def id = response.id
* print 'created id is: ' + id

# Given path id
# When method get
# Then status 200
# And match response contains user

