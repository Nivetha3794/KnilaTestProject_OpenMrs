Feature: Validate Login Feature

 Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user select the location
    And user clicks on Login button
    And user navigated to Register a Patient page
		When user enters "<givenname>" and "<middlename>" and "<familyname>"
		When User selects Unidentified Patient
		When User selects gender
		And User clicks on continue and confirm button
		Then User account should get created sucessfully
		
Examples:
    |username|password|givenname|middlename|familyname|
    |Admin|Admin123|Nivetha|S|sri|
    