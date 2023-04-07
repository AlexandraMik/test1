Feature: Test art is presented
  Scenario: Check if item is in current category
    When user goes to category1 category
    When user picks genre genre1
    Then current picture is presented