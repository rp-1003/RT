Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

  Scenario: User changes password successfully
    Given Account exists for Acc No. "12345678" with Name "Bob Smith"
    And deposits are made
      | transactionId | amount |
      | INIT           | 200    |
      | DEP1           | 100    |
      | DEP2           | 450    |
      | DEP3           | 50     |
    And withdrawals are made
      | transactionId | amount |
      | CHQ001         | 675.55 |
    When statement is produced
    Then statement includes "Name: Bob Smith"
    And statement includes "Account: 12345678"
    And statement includes "Balance: 124.45"
    And statement includes "INIT"
    And statement includes "DEP1"
    And statement includes "DEP2"
    And statement includes "DEP3"
    And statement includes "CHQ001"
    Then soft assertions are finished
