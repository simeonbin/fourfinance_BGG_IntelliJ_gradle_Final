Feature: Number Games
  So that GameInfo can be validated
  As a UAT tester of Game Collections
  I want to enter a username a game objectId of his game collection and see correct info

  Scenario Outline: Game Collection of a user
    Given I use "mkgray" as a username
    When I use "SimBin" as a firefoxProfile
    Then I should be told the correct answer for language dependence text is result$"

    Examples:
      | userName | firefoxProfile |
      | mkgray   | SimBin         |


  Scenario Outline: Game Collection of a user
    Given I use "mkgray" as a username
    When I use "SimBin" as a firefoxProfile
    Then I should be told Most Voted is Level num1 with Votes num2 and language dependency ld"

    Examples:

      | userName | firefoxProfile |
      | mkgray   | SimBin         |


  Scenario Outline: Game Collection of a user
    Given I use "mkgray" as a username

    Then I should be told number of Games is number"

    Examples:

      | userName |
      | mkgray   |

  Scenario Outline: Game Collection of a user
    Given I use "mkgray" as a username

    Then I should be told chosen random number in Games is number1 and chosen ObjectId is number2"

    Examples:

      | userName |
      | mkgray   |

  Scenario Outline: Game Collection of a user
    Given I use "mkgray" as a username

    Then I should be told chosen name of Game is name"

    Examples:

      | userName |
      | mkgray   |