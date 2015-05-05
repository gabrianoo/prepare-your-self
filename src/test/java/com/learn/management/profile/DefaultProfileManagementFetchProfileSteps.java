package com.learn.management.profile;

import com.learn.service.media.MediaBusinessObject;
import com.learn.service.user.User;
import com.learn.service.user.UserBusinessObject;
import com.learn.service.user.UserService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;

@Named
public class DefaultProfileManagementFetchProfileSteps {

    private final Integer validUserId = 1;
    final String validUserFirstName = "FirstName";
    final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultProfileManagement")
    private ProfileManagement profileManagement;
    private Integer testProfileUserId;
    private Profile testProfile;
    @Inject
    private UserService userService;

    @PostConstruct
    public void initializeDefaultProfileManagementFetchingProfileSteps() {
        doReturn(buildValidUser()).
                when(userService).createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
    }

    private User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private Profile buildValidProfileWithoutMedia() {

        return Profile.newBuilder()
                .user(
                        buildValidUser()
                ).build();
    }

    @Given("valid profile user id for fetching")
    public void validProfileUserIdForFetching() {
        testProfileUserId = 1;
    }

    @When("fetching profile with valid profile user id")
    public void fetchingProfileWithValidProfileUserId() {
        profileManagement.fetchProfile(testProfileUserId);
    }

    @Then("profile with valid profile user id fetched")
    public void profileWithValidProfileUserIdFetched() {
        assertThat(buildValidProfileWithoutMedia(), equalTo(testProfile));
    }
}
