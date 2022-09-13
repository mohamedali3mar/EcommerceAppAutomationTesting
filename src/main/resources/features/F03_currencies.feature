@smoke
Feature: F03_Currency | users could change currency of the displayed products

  Scenario: user could change currency of products from the dropdown menu
    Given user is in the home page
    When user select "Euro" currency
    Then all products in home page have the euro symbol currency