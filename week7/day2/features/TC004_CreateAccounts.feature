Feature: Create Accounts functionality of Salesforce Application

Background: 
Given Login to Salesforce application

@Unit
Scenario: Create new Account
Given Click on toggle menu button from the left corner
And Click view All 
And Click 'Sales' from App Launcher
And Click on Accounts tab 
And Click on 'New' button 
And Enter 'Rani' as account name 
And Select Ownership as Public
When Click save 
Then Verify 'Account' name