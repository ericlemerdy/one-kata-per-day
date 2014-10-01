Feature: Shopping basket payment

  # Given a user has a few items in her shopping basket
  # When she submits the payment details
  # Then she receives the payment confirmation
  Scenario: Item not in stock
    Given user has a shopping basket with an item "Kriptonite" not in stock
    When the user checkout
    Then the payment is aborted
    And the user is informed that "Kriptonite" is out of stock
