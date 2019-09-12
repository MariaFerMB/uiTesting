Feature: Sign out

  Scenario: Succesful sign out
    Given I am in the Falabella homepage
    And I sign in with the next credentials
      | Email    | challengecorreo@gmail.com |
      | Password | clavechallenge            |
    When I click in the sign out button
    Then I should see the sign out message: "Inicia sesiónMi cuenta"




