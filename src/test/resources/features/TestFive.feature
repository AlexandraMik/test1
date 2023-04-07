Feature: basket
  Scenario: Add item in basket and check
    When user goes to jewelry
    When user adds first in basket
    When user goes to basket
    Then current item in basket and nothing changed