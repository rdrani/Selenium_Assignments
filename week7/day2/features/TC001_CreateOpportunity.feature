Feature: Create Opportunity functionality of Salesforce Application

Background: 
Given Login to Salesforce application

@Smoke
Scenario: Create new Opportunity
Given Click on toggle menu button from the left corner
And Click view All 
And Click 'Sales' from App Launcher
And Click on Opportunities tab
And Click on 'New' button
And Enter Opportunity name as 'Salesforce Automation by Rani', Get the text and store it
And Choose close date as Today
And Select Stage as Needs Analysis
When Click save
Then Verify 'Opportunity' name

@Regression
Scenario: Create Opportunity without mandatory fields
Given Click on toggle menu button from the left corner
And Click view All 
And Click 'Sales' from App Launcher
And Click on Opportunities tab
And Click on 'New' button
And Choose Close date as Tomorrow Date
When Click save
But Verify the Alert message 'Complete this field' displayed for Name and Stage
