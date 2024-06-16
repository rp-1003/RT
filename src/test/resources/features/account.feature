Feature: Account statement

  Background:
    Given Account exists for Acc No. "12345678" with Name "Bob Smith"
    And deposits are made
      | description | amount |
      | INIT        | 200    |
      | DEP1        | 100    |
      | DEP2        | 450    |
      | DEP3        | 50     |
    And withdrawals are made
      | description | amount |
      | CHQ001      | 675.55 |
    When statement is produced

  @regression
  Scenario: Statement includes account details
    Then statement includes "Name: Bob Smith"
    And statement includes "Account: 12345678"

  @regression
  Scenario: Balance is calculated on the statement
    Then statement includes "Balance: 124.45"

  @regression
  Scenario: Statement includes transaction details
    Then statement includes "INIT"
    And statement includes "DEP1"
    And statement includes "DEP2"
    And statement includes "DEP3"
    And statement includes "CHQ001"
