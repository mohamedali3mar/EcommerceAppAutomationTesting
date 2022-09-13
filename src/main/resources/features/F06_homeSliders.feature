@smoke
Feature: F06_HomeSliders | users could navigate to the page of the product displayed in the homepage sliders

  Scenario: users could search for products of specific category
    Given user is in the home page
    When user click on slider number "1"
    And user click on the displayed product image
    Then user gets directed to the product url "https://demo.nopcommerce.com/nokia-lumia-1020"


  Scenario: users could search for products of specific category
    Given user is in the home page
    When user click on slider number "2"
    And user click on the displayed product image
    Then user gets directed to the product url "https://demo.nopcommerce.com/iphone-6"