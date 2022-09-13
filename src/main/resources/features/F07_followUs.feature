@smoke
Feature: F07_followUs | users could open followUs links

  Scenario Outline: user opens a social link
    When user opens "<socialMediaName>" link
    Then user is navigated to new tab of url contains "<socialMediaName>.com"
    Examples:
    |socialMediaName|
    |facebook       |
    |twitter        |
    |rss            |
    |youtube        |