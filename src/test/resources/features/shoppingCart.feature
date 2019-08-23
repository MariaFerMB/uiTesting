Feature: Shopping cart

  Scenario: Add a product to the shopping cart
    Given I am in a product page
    When I add the product to the cart
    Then I should see a pop up with the confirmation