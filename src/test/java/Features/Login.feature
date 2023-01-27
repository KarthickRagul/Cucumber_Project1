Feature: Login

Scenario Outline: Successfull login with Valid customer details
  Given The user is on the login page
  When The user enters the valid username "<username>" and password "<password>" and clicks login
  Then The Home should be displayed

  Examples:
    |username     |password|
    |standard_user|secret_sauce|

Scenario: Unsuccessfull login with Locked customer details
  Given The user is on the login page
  When The user enters the valid username "locked_out_user" and password "secret_sauce" and clicks login
  Then The error message should be displayed

Scenario: Successfull logout
  Given The user is logged in with username "standard_user" and password "secret_sauce" and in the home page
  When The user clicks on the hamburger button
  And The user Clicks logout
  Then The login page should be displayed

