Feature: Sign out

  Scenario: Succesful sign out
    Given I am signed in the Falabella page
    When I sign out
    Then I should be signed out


