Feature: Duplicate Lead functionality of Leaftaps Application

Background:
Given Open the Chrome browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario Outline: Duplicate existing Lead
When Click on CRMSFA link
And Click on Leads link
And Click on Find Leads link
And Click on Phone tab
Given Enter the phone number to find lead as <phNumber>
When Click on Find Leads button
And Capture lead ID of First Resulting lead
And Capture lead name of First Resulting lead
And Click on the first Lead from the results
And Click on Duplicate Lead
When Click on submit button
Then Verify lead name displayed is same as captured lead name
Then Close the browser

Examples:
|phNumber|
|99|
|98|