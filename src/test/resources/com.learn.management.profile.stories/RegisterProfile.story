Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
I want to register my profile on the system

Scenario: Registering new profile in our system

Given valid user and no media for profile register
When register profile with valid user and no media
Then profile with valid user and no media registered

Given no user and valid media for profile register
When register profile with no user and valid media
Then IllegalArgumentException should be thrown for missing user when register

Given valid user and valid media for profile register
When register profile with valid user and valid media
Then profile with valid user and valid media registered
