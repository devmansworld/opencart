Feature: Cart Functionality

  Scenario: Search for a product and count occurrences
    Given I am on the cart page
    When I search for "tennis ball"
    Then I should see 3 occurrences of "tennis ball"

  Scenario: Add a product to the cart and delete it
    Given I am on the cart page
    When I add "Product A" to the cart
    Then I should see "Product A" in the cart
    When I go to the cart
    And I delete "Product A" from the cart
    Then I should not see "Product A" in the cart
