Feature: Create Lead functionality of Leaftaps Application

Background:
Given Open the Chrome browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario Outline: Create new Lead
When Click on CRMSFA link
And Click on Leads link
And Click on CreateLead link
Given Enter the companyName as <companyName>
And Enter the firstName as <firstName>
And Enter the lastName as <lastName>
And Enter the phone number as <phNumber>
When Click on submit button
Then ViewLeads page should be displayed as <companyName>
Then Close the browser

Examples:
|companyName|firstName|lastName|phNumber|
|TestLeaf|Subraja|Subi|99|
|Qeagle|Vidhya|R|98|