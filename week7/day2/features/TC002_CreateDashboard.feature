Feature: Create Dashboard functionality of Salesforce Application

Background: 
Given Login to Salesforce application

@Functional
Scenario: Create new Dashboard
Given Click on toggle menu button from the left corner
And Click view All 
And Click 'Dashboards' from App Launcher
And Click on 'New Dashboard' button 
And Enter Name as 'Salesforce Automation by Rani'
When Click Create
And Click save
Then Verify Dashboard Name
