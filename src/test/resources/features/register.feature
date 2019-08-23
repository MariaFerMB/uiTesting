Feature: Register

  Scenario: Invalid registration
    Given I am in the Falabella homepage
    When I try to register
    And I fill all the field except for "celular"
    And I try to save my data
    Then I should see a error message