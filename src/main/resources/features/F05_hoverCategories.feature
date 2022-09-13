@smoke
Feature: F05_Categories | users could search for products using specified categories

  Scenario: users could search for products of specific category
    When users selects random category
    Then the category title is the same as the randomly selected category