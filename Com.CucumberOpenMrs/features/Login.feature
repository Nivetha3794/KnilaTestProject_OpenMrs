Feature: Validate Login Feature

 Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user select the location
    And user clicks on Login button
    And user navigated to Register a Patient page
		When user enters "<givenname>" and "<middlename>" and "<familyname>"
#		When User selects Unidentified Patient
		When user clicks continue by selects gender
		And User Clicks next button enters 03 and "<month>" and 2000
#		When User selects gender
		When user enters address details and phonenumber
		And User enters the "<reltype>" and "<personname>"
		And User clicks by continue and validating the information
		Then User clicks confirm button should get account created sucessfully
		
Examples:
    |username|password|givenname|middlename|familyname|month|reltype|personname|
    |Admin|Admin123|Nivetha|S|sri|May|Parent|Micheal|
    
Scenario: Uploade file in the File attachment page
	Given User is on the attachment page
	When User clicks on Startvisit link 
	And clicks on confirm button
	When User clicks the Attachments link
	Then User should be on the file attachment page
	
Scenario: to Test uploaded file is displayed
	Given User is on File Upload Page
	When User select the upload link
	And User enters caption in the text box "MedicalDocument"
	And User clicks the upload file button
	Then User should see a Success toast message
	And uploaded file is displayed on the home page
    