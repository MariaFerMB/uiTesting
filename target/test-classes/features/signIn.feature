Feature: Sign In

  Background:
    Given I am in the Falabella homepage

  Scenario: Succesful sign in
    When I sign in with valid credentials
    Then I should be signed in

  Scenario: Unsuccesful sign in
    When I sign in with invalid credentials
    Then I should see a sign in error

