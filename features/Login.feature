#Each feature file contains on feature
#Feature files use a Gherkin language - business language
Feature: Test the login functionality on sdet university
#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
#Gherkin language
Scenario: the user should be able to login with correct username and correct password
Given: user is on login page
When: user enters correct username and correct password
Then: user gets confirmation