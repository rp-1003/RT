Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Background:
    Given the user is logged in with username "testUser" and password "oldPassword"

  @regression
  Scenario: Successful password change
    When the user changes the password from "oldPassword" to "NewPass123!" and confirms it
    Then the password should be successfully changed

  @regression
  Scenario: Password change with invalid current password
    When the user tries to change the password from "wrongPassword" to "NewPass123!" and confirms it
    Then an error message "Current password is incorrect" should be displayed

  @regression
  Scenario: Password change with mismatched new password and confirmation
    When the user tries to change the password from "oldPassword" to "NewPass123!" and confirms it as "NewPass124!"
    Then an error message "New password and confirmation do not match" should be displayed

  @regression
  Scenario: Password change with a new password that does not meet the rules
    When the user tries to change the password from "oldPassword" to "short" and confirms it
    Then an error message "New password does not meet the required rules" should be displayed
