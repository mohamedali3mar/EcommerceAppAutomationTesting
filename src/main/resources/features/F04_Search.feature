@smoke
Feature: F04_Search | users could search for products

  Scenario Outline: user could search using product name
    Given user is in the home page
    When user search with "<productName>"
    Then search result appears
    And all products in the result are relevant to the search keyword "<productName>"
    Examples:
    | productName |
    | BOOK |
    | laptop |
    | NIKE |

  Scenario Outline: user could search using product name
    Given user is in the home page
    When user search with "<productSKU>"
    Then search result appears
    And user click on the product in search result
    And the product's sku contains the searched "<productSKU>"
    Examples:
      | productSKU |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |