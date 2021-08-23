#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


# User story, User Steps, Behaviour, Test Case
@smoke
Feature: Test the e-commerce app landing page
  For smoke test
  1. URL Redirection
  2. Landing page title test
  

  @appRedirection
  Scenario: Test the Url redirection for the application
    Given User open the browser
    And user maximize the browser
    When User open the Url "http://automationpractice.com/"
    Then User is gets redirected to "http://automationpractice.com/index.php"
    And User close the browser
    
  @appTitleTest
  Scenario: Test the app landing page title
  	Given User open the browser
    And user maximize the browser
    When User open the Url "http://automationpractice.com/"
    Then User is able to see the app title "My Store"
    And User close the browser

   

  #@titletest
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
