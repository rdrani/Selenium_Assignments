Feature: Merge Lead functionality of Leaftaps Application

Background:
Given Open the Chrome browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario Outline: Merge existing leads
When Click on CRMSFA link
And Click on Leads link
And Click on Merge Leads link
And Click on lookup widget of From Lead
And Change driver control to popup window
And Enter the firstName of From Lead as <firstNameFrom>
When Click on Find Leads button
And Capture lead ID of First Resulting lead
And Click on the first Lead from the results
And Switch driver control back to main window
And Click on lookup widget of To Lead
And Change driver control to popup window
And Enter the firstName of To Lead as <firstNameTo>
When Click on Find Leads button
And Click on the first Lead from the results
And Switch driver control back to main window
And Click on Merge button
And Accept the alert 
And Click on Find Leads link
And Enter captured Lead Id
When Click on Find Leads button
Then Verify leads are merged
Then Close the browser


Examples:
|firstNameFrom|firstNameTo|
|Subraja|Vidhya|
|Thomas|Hari|