Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
I want to read my profile on the system

Scenario: Fetching a profile in our system

Given valid profile user id for fetching
When fetching profile with valid profile user id
Then profile with valid profile user id fetched
