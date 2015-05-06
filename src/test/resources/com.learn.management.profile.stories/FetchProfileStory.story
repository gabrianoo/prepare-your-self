Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
I want to read my profile on the system

Scenario: Fetching a profile in our system

Given valid user id for fetching
When fetching profile with valid user id
Then profile with valid user id fetched

Given missing user id for fetching
When fetching profile with missing user id
Then IllegalArgumentException should be thrown for missing user id when fetching

Given invalid user id for fetching
When fetching profile with invalid user id
Then IllegalArgumentException should be thrown for invalid user id when fetching
