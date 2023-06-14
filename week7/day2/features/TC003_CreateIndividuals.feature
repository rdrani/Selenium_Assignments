Feature: Create Individual functionality of Salesforce Application

Background: 
Given Login to Salesforce application

@Sanity
Scenario: Create new Individual
Given Click on toggle menu button from the left corner
And Click view All 
And Click 'Individuals' from App Launcher
And Click on 'New' button 
And Enter the Last Name as 'Kumar' 
When Click save individual
Then Verify 'Individuals' name
