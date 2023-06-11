Feature: Edit Lead functionality of Leaftaps Application

Background:
Given Open the Chrome browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario Outline: Edit existing Lead
When Click on CRMSFA link
And Click on Leads link
And Click on Find Leads link
And Click on Phone tab
Given Enter the phone number to find lead as <phNumber>
When Click on Find Leads button
And Click on the first Lead from the results
And Click on the Edit button
And Enter the company name to edit as <companyName>
When Click on submit button
Then ViewLeads page should be displayed with company name as <companyName>
Then Close the browser

Examples:
|phNumber|companyName|
|99|TestLeaf|
|98|Qeagle|