Feature: search
  Scenario: Searching giraffe
    When user search giraffe
    Then name of first item contains giraffe