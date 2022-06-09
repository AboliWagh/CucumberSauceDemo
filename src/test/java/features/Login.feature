Feature: This feature would be used to design the Login page of the SauceDemo application

  Background: Open the Swag Labs application
    Given User is on SauceDemo Login Page
	
	@Regression
  Scenario Outline: validate the positive login
    When User enters Username "<username>" and Password "<password>"
    And User clicks on Login button
    Then User lands on the Product Page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario Outline:  validate the negative login
    When User enters Username "<username>" and Password "<password>"
    And User clicks on Login button
    Then User gets the error message as "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | username    | password     |
      | Pqrst      | sauce |
      | user | dferg |