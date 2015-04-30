Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
I want to register my profile on the system

Scenario: Registering new profile in our system

Given valid profile information without media
When I register this profile
Then profile should be saved successfully

Given profile information with missing profile first name
When I register this profile
Then IllegalArgumentException should be thrown

Given profile information with missing profile email
When I register this profile
Then IllegalArgumentException should be thrown

Given valid profile information with invalid media name
When I register this profile
Then IllegalArgumentException should be thrown

Given valid profile information with invalid media extension
When I register this profile
Then IllegalArgumentException should be thrown

Given valid profile information with invalid media bytes
When I register this profile
Then IllegalArgumentException should be thrown

Given valid profile information with valid media
When I register this profile
Then profile should be saved successfully