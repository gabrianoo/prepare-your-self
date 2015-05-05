Meta:

@category basic
@color blue

Narrative:
In order to show the basic profile functionality
As a user
want to update my profile on the system

Scenario: Updating profile in our system

Given valid user and no media for profile update
When update profile with valid user and no media
Then profile with valid user and no media updated

Given no user and valid media for profile update
When update profile with no user and valid media
Then profile with no user and valid media updated

Given valid user and valid media for profile update
When update profile with valid user and valid media
Then profile with valid user and valid media updated