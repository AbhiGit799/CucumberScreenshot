Feature: User Open Chrome Browser
  @First
  Scenario: User will Open Chrome Browser
    Given User "ABC" open chrome browser
    Given User "ABC" open youtube
    And User "ABC" close chrome browser skip screenshot

  @Learning
  Scenario: User will Open Chrome Browser
    Given User "ABC" open udemy