Feature: This is Cat Controller test
  We will check all CRUD endpoints

  Background:
  # this section is optional !
  # steps here are executed before each Scenario in this file
  # variables defined here will be 'global' to all scenarios
  # and will be re-initialized before every scenario
  * def cat1 = { id: 1, name: 'Monk', age: 5}

  Scenario: Lets add one cat and check if exists
    
    Given url mainUrl
    And path 'cats'
    When method get
    Then status 200
    And def al = response.length
    And print 'Length: ', al

    When request cat1
    When path 'cats'
    And method post
    Then status 201
    And match response.id == al +1

    When path 'cats'
    When method get
    Then status 200
    And print response
#    And match response[0].id == 1
    And match response.length == al + 1



