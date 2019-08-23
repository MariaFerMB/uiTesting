Feature: Sign out

  Scenario: Succesful sign out
    Given I am in the Falabella homepage
    And I sign in with valid credentials
    When I sign out
    Then I should be signed out




