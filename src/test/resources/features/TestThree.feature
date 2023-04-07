Feature: First item in category Batik is in Favorites
  Scenario: Check if item in Favorites
    When user goes to category batik
    When user adds first item in fav
    When user goes to fav
    When current item in fav