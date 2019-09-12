Feature: Shopping cart

  Background:
    Given I am in a product page
    When I add the product to the cart

  Scenario: Add a product to the shopping cart

    Then I should see a pop up with the confirmation

  Scenario: Delete a product from the shopping cart

    And I go to the shopping cart page
    And I delete the product
    Then I should see a message: Tu Bolsa de Compras está vacía. Agrega productos ahora>>Seguir comprando