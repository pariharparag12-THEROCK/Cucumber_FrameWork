Feature: Amazon HomePage Functionality

Scenario: validate the Title of homepage
Given user must be on the homepage
Then Page Tiltle should contain "Online"

Scenario: validate the availability of cart icon
Given user must be on the homepage
Then Cart icon should get displayed to user

Scenario: validate user able to search mobile
Given user must be on the homepage
When user search "mobile" in the search field
Then user should see the mobiles
When user clicks on mobile
Then user should be navigated to mobile page