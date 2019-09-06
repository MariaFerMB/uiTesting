Feature: Sign In

  Background:
    Given I am in the Falabella homepage

  Scenario: Succesful sign in
    When I sign in with the next credentials
      | Email    | challengecorreo@gmail.com |
      | Password | clavechallenge            |
    Then I should see the sign in message: "Bienvenid@,David"

  Scenario: Unsuccesful sign in
    When I sign in with the next credentials
      | Email    | challenge@gmail.com |
      | Password | clavechallenge      |
    Then I should see the sign in error message: E-mail o clave incorrecta. Por favor inténtalo nuevamente.

