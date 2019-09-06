Feature: Register

  Scenario: Invalid registration
    Given I am in the Falabella homepage
    When I try to register
    And I fill all the field except for "celular"
      | User name        | Laura Camila              |
      | Father last name | Rojas                     |
      | Mother last name | Rodriguez                 |
      | Email            | lauraCamiRojasR@gmail.com |
      | Password         | qwer1234                  |
      | Verify password  | qwer1234                  |
      | Country          | Colombia                  |
      | Document type    | Cédula de ciudadanía      |
      | Document number  | 1023549864                |
      | Gender           | Female                    |
      | Birth day        | 12                        |
      | Birth month      | Ago                       |
      | Birth year       | 1995                      |
    And I try to save my data
    Then I should see a error message: Debes ingresar un celular