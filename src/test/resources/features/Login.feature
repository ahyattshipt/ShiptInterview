Feature: Login Page

  Scenario Outline: Invalid Username or Password
    Given I am in session "Customer"
    When I go to the login page
    And I login with email "<email>" and password "<password>"
    Then the invalid login message should have text "Invalid Username or Password"

  Examples:
    | email                 | password |
    | test@test.com         | test     |
    | ahyattshipt@gmail.com | password |
