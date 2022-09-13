@smoke
Feature: F08_Wishlist | users can add items to his wishlist

  Scenario: user successfully add items to wishlist
    Given user is in the home page
    When user add product to wishlist using the heart icon
    Then a message of success addition with green background is displayed

  Scenario: user finds the correct quantity of items added to wishlist
    Given user is in the home page
    When user add product to wishlist using the heart icon
    And waits for the green message to disappear
    Then user go to wishlist page
    And user have quantity of items in his wishlist greater than zero