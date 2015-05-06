Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
I want to delete my profile on the system

Scenario: Un Registering a profile in our system

Given valid user id for un registering
When un registering profile with valid user id
Then profile with valid user id un registered

Given missing user id for un registering
When un registering profile with missing user id
Then IllegalArgumentException should be thrown for missing user id when un register

Given invalid user id for un registering
When un registering profile with invalid user id
Then IllegalArgumentException should be thrown for invalid user id when un register
