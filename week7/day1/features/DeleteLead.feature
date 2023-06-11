Feature: Delete Lead functionality of Leaftaps Application

Background:
Given Open the Chrome browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario Outline: Delete existing Lead
When Click on CRMSFA link
And Click on Leads link
And Click on Find Leads link
And Click on Phone tab
Given Enter the phone number to find lead as <phNumber>
When Click on Find Leads button
And Capture lead ID of First Resulting lead
And Click on the first Lead from the results
And Click on Delete button
And Click on Find Leads link
And Enter captured Lead Id
When Click on Find Leads button
Then Verify no results are displayed
Then Close the browser

Examples:
|phNumber|
|99|
|98|