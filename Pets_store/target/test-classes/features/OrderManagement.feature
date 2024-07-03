Feature: Order Management at PetStore

  Scenario: Create an Order
    Given I have an order payload with "1" and "1"
    When I submit a POST request to create an order
    Then the status code should be 200

  Scenario Outline: Retrieve an Order by ID
    Given I have an order ID "<orderId>"
    When I submit a GET request to retrieve the order
    Then the status code should be 200
    And the order details for "<orderId>" should be returned successfully

    Examples:
      | orderId |
      | 1       |
      | 2       |
