Feature: Test art is with correct style
  Scenario: Check if item is in correct style
    When user again goes to category1 category
    When user again picks genre genre1
    When user clicks on picture
    Then current item style is correct