Feature: Collection management

  Scenario: Login add and delete collection
    Given user is on awards login page
    When user logs in with valid credentials
    And user adds a collection
    And user deletes the collection
    Then collection should be deleted successfully