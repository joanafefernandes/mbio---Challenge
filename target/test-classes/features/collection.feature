
@tag
Feature: Collection

  @tag1
  Scenario: Buy a product on Mercedes-Benz online store
    Given I am on page collections
    When I close cookies panel
    And I select Collection and accessories link
    And I select all product
    And I select see all products
    Then I am on collectioin and accessories page
    When I select one product
    And I add product to the basket
    Then a pop-up display
    When I go to shooping basket
    Then cart page display
    When I continue to address and delivery
    Then Address and delivery step display
    When I insert an email to place order as a guest
    And choose place order as a guest
    Then shipping page display
    When I fill user details
    And continue to payment step
    Then payment step display
    When I choose paypal method
    And continue to verification and order placement
    Then Verification and order placement page display

